package cl.samtech.ot.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import cl.samtech.ot.AgendaActiva;
import cl.samtech.ot.UsuarioLogin;
import cl.samtech.ot.form.CrearTareaForm;
import cl.samtech.ot.util.RandomStringUUID;
import cl.samtech.ot.util.sendMail;
import model.Agenda;
import model.Comprobante;
import model.DetalleComprobante;
import model.FotoFirma;
import model.Instalacion;
import model.Ot;
import model.Periferico;
import model.ResumenIfo;
import model.SamFicha;
import model.SamFichaHardware;
import model.SamHardware;
import model.SamUsuario;

public class TareasService {
	private static EntityManager em;
	private static EntityManager em1;
	private static EntityManager em2;
	private static EntityManager em3;
	private static EntityManager em4;
	private static EntityManager em5;
	private static EntityManager em6;
	
	final static Logger logger = Logger.getLogger(TareasService.class);
	
	public static ArrayList<AgendaActiva> allTareas(UsuarioLogin user) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("samtech");

		em = emf.createEntityManager();
		em1 = emf1.createEntityManager();
		//List<Agenda> tareas = null;
		List<Object[]> tareas = null;
		/*Query query = em.createNativeQuery("select a from Agenda a where a.titulo <> 'PREAGENDAMIENTO' "
				+ "and a.usuarioAsigna = :username and a.fechaComienzo > :fecha and  a.fechaComienzo < :fechaf order by a.fechaComienzo desc");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("username", user.getUsername());*/
		
		
		//query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		//query.setParameter("username", user.getUsername());
		
		Date fechahoy = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechahoy);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		fechahoy = calendar.getTime();
		java.sql.Timestamp timefec2 = new Timestamp(fechahoy.getTime());
		
		calendar.add(Calendar.DAY_OF_YEAR, -10);
		fechahoy = calendar.getTime();

		java.sql.Timestamp timefec = new Timestamp(fechahoy.getTime());
		Query query = em.createNativeQuery("select * from"
				+ " (select a.id,a.titulo,a.fecha_comienzo,a.empresa,a.contacto,a.telefono,a.patentes,a.direccion,a.descripcion,a.usuario_asigna usuario,'Responsable' tipo,a.folio_anexo"
				+ " from Agenda as a where  a.titulo = 'INSTALACION' and a.usuario_asigna = '"+user.getUsername()+"' and a.fecha_comienzo >= '"+timefec.toString().replace(" ", "T")+"'"
				+ " and  a.fecha_comienzo <= '"+timefec2.toString().replace(" ", "T")+"'"
				+ " union all"
				+ " select a.id,a.titulo,a.fecha_comienzo,a.empresa,a.contacto,a.telefono,a.patentes,a.direccion,a.descripcion,ap.usuario_apoya usuario,'Apoyo' tipo,a.folio_anexo"
				+ " from Agenda as a LEFT JOIN agenda_usuario_apoya as ap ON a.id = ap.id_agenda where a.fecha_comienzo >= '"+timefec.toString().replace(" ", "T")+"'"
				+ " and  a.fecha_comienzo <= '"+timefec2.toString().replace(" ", "T")+"' and a.titulo = 'INSTALACION' and ap.usuario_apoya = '"+user.getUsername()+"')"
				+ " q1 order by q1.fecha_comienzo desc ");

		tareas = query.getResultList();

		ArrayList<AgendaActiva> tareasactivas = new ArrayList<AgendaActiva>();
		try {
			for (Object[] t : tareas) {

				AgendaActiva aa = new AgendaActiva();				
				aa.setId(Long.parseLong(t[0].toString()));
				aa.setTitulo(t[1].toString());
				java.sql.Timestamp fechaC = Timestamp.valueOf(t[2].toString());		
				aa.setFechaComienzo(fechaC);
				SamFicha empresa = em1.find(SamFicha.class, Integer.parseInt(t[3].toString()));
				int estado = estadoOt(Long.parseLong(t[0].toString()),fechaC);
				Long instalacion = InstalacionService.countInstalacion(Long.parseLong(t[0].toString()));
				int inst = verificarUltimaTarea(Long.parseLong(t[0].toString()),String.valueOf(empresa.getFichCodigo()),t[11].toString());
				aa.setInstalaciones(inst);
				aa.setCountInst(instalacion);
				aa.setEstado(estado);
				aa.setEmpresa(empresa.getFichRazonSocial());
				aa.setLogin_cliente(empresa.getFichLoginCliente());
				aa.setContacto(t[4].toString());
				aa.setResponsable((t[10].toString()));
				aa.setPatentes(t[6].toString());
				aa.setDireccion(t[7].toString());
				aa.setDescripcion(t[8].toString());
				tareasactivas.add(aa);	
			}

		} catch (NoResultException e) {
			e.getMessage();
		}

		return tareasactivas;
	}
	
	public static int estadoOt(Long id,Timestamp fechaComienzo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em = emf.createEntityManager();
		Ot ot = null;	
		//Ot tarea = em.find(Ot.class, id);	
		Query query = em.createQuery("SELECT ot FROM Ot ot where ot.id = :id_ot");
		query.setParameter("id_ot",id);
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
			
		if(query.getResultList().isEmpty()) {
			ot = crearOT(id,fechaComienzo);
		}else {
			ot = (Ot) query.getResultList().get(0);
			if(ot.getEstado() ==  null) {
				ot.setEstado(0);
			}
		}
		return ot.getEstado();
	}
	
	public static  SamFicha findSamFicha(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("samtech");
		em4 = emf.createEntityManager();
		SamFicha empresa = em4.find(SamFicha.class, id);
		return empresa;
	}
	
	public static Agenda findTarea(Long id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		em3 = emf.createEntityManager();
		Agenda tarea = em3.find(Agenda.class, id);
		// em.refresh(tarea);
		Ot ot = findOT(id);
		
		return tarea;
	}
	
	public static Agenda findAgenda(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		em3 = emf.createEntityManager();
		Agenda tarea = em3.find(Agenda.class, id);
		return tarea;
	}

	public static Ot findOT(Long id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em = emf.createEntityManager();
		Query query = em.createQuery("SELECT t FROM Ot t where t.id = :id");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("id",id);
		Ot tarea = (Ot) query.getResultList().get(0);
		em.clear();
		return tarea;
	}

	public static Ot crearOT(Long id,Timestamp fechaComienzo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		em = emf.createEntityManager();
		Ot tarea = new Ot();
		tarea.setId(id);
		tarea.setEstado(0);
		tarea.setFechainicio(fechaComienzo);
		
		em.getTransaction().begin();
		em.persist(tarea);
		em.getTransaction().commit();
		em.close();
		return tarea;
	}

	public static Boolean existeTarea(Integer idfalla, Integer idubicacion) {

		Boolean existe = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		em = emf.createEntityManager();
		Query query = em.createQuery(
				"select t from Tarea t where t.falla.idFalla = :idfalla and t.ubicacion.idUbicacion = :idubicacion");
		query.setParameter("idfalla", idfalla);
		query.setParameter("idubicacion", idubicacion);

		List resultList = query.getResultList();
		if (resultList != null && !resultList.isEmpty()) {
			existe = true;
		}

		return existe;
	}

	public static Long findnextTarea(Long idTarea, String usuario) {

		Long id = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");
		em = emf.createEntityManager();
		Query query = em
				.createQuery("select t from Tarea t where t.idTarea >:idtarea and t.usuario.username= :usuario");
		query.setParameter("idtarea", idTarea);
		query.setParameter("usuario", usuario);
		query.setMaxResults(1);

		List<Agenda> resultList = query.getResultList();
		if (resultList != null && !resultList.isEmpty()) {
			id = resultList.get(0).getId();
		}

		return id;
	}
	public static Boolean FinalizarTarea(UsuarioLogin user, String fechaInicio, Long id, String observaciones,
			String url, String nombre, String tipoActividad, Integer folio, Integer anexo, String nombreCliente,
			String rutCliente, String cargo, String email,String horaInicio,boolean validaracc,String perifericos) throws DocumentException {
		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("otsamtechDB");
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("TrasladoDB");
		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("gpsf");
		EntityManagerFactory emf3 = Persistence.createEntityManagerFactory("samtech");
		em = emf.createEntityManager();
		em1 = emf1.createEntityManager();
		em2 = emf3.createEntityManager();
		em5 = emf.createEntityManager();
		em6 = emf.createEntityManager();
		Agenda agenda = em1.find(Agenda.class, id);
		SamFicha empresa = em2.find(SamFicha.class, Integer.parseInt(agenda.getEmpresa()));
		
		List<Instalacion> inst = null;
		List<Periferico> pp = null;
		
		
		try {
			//comprobar si la ultima instlacion ej: 5 de 5 
			int comprobador = verificarUltimaTarea(id,String.valueOf(folio),String.valueOf(anexo));
			
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			Date parsedDate = dateFormat.parse(fechaInicio);
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			
			FotoFirma ff = new FotoFirma();
			ff.setNombre(nombre);
			ff.setUrl(url);
			em.getTransaction().begin();
			em.persist(ff);
			em.getTransaction().commit();
			em.clear();
			
			Ot ot = em.find(Ot.class, id);
			if(comprobador ==  1) {
				ot.setEstado(1);
				ot.setFechatermino(timestamp);
				em.getTransaction().begin();
				em.persist(ot);
				em.getTransaction().commit();
			}
					
			inst = ot.getInstalacions();
			
			boolean creado = createPDF(empresa,horaInicio,user,agenda,inst,folio,anexo,observaciones,nombreCliente,rutCliente,cargo,email,url,validaracc,perifericos);
			
			if(creado) {
				ff.getId();
				Comprobante comprobante = new Comprobante();
				comprobante.setFecha(timestamp);
				comprobante.setObservacion(observaciones);
				comprobante.setFotoFirma(ff);
				comprobante.setAnexo(String.valueOf(anexo));
				comprobante.setFolio(String.valueOf(folio));
				em6.getTransaction().begin();
				em6.persist(comprobante);
				em6.getTransaction().commit();
				
				for (Instalacion insta : inst) {
					insta = em5.find(Instalacion.class, insta.getId());
					insta.setEstado(3);
					em5.getTransaction().begin();
					em5.persist(insta);
					em5.getTransaction().commit();
	
					comprobante.getId();
					DetalleComprobante dc = new DetalleComprobante ();
					dc.setComprobante(comprobante);
					dc.setIdInstalacion(insta.getId().intValue());
					dc.setIdOt(ot.getId().intValue());
					em.getTransaction().begin();
					em.persist(dc);
					em.getTransaction().commit();
					em.clear();
				}		
			}
				
		} catch (Exception e) {
			grabado = false;
		}
		/*
		try {
			// agenda.setColor("green");
			// agenda.setEstado(1);

			// em1.getTransaction().begin();
			// em1.persist(agenda);
			// em1.getTransaction().commit();

		} catch (Exception e) {
			grabado = false;
		}*/
		// insercion de Firma
		return grabado;
	}
	
	public static int verificarUltimaTarea(Long id_ot,String folio,String anexo) {
		
		String numPend = InstalacionService.NumSolicitadas(id_ot);
		Integer numInstaladas = InstalacionService.numInstaladas(folio,anexo);
		int validador = 0;
		if(numInstaladas == Integer.parseInt(numPend)) {
			validador = 1; 	
		}
		return validador;
	}
	
	public static Boolean modificarTarea(CrearTareaForm crearTareaForm, UsuarioLogin user) {

		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");

		em1 = emf.createEntityManager();

		Agenda tarea = em1.find(Agenda.class, crearTareaForm.getIdTarea().intValue());

		tarea.setDescripcion(crearTareaForm.getDescripcion());

		tarea.setTelefono(crearTareaForm.getTelefono());

		try {
			em1.getTransaction().begin();
			em1.persist(tarea);
			em1.getTransaction().commit();

		} catch (Exception e) {
			grabado = false;
		}

		return grabado;
	}

	public static Boolean completarTarea(long id) {

		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");

		em1 = emf.createEntityManager();

		Agenda tarea = em1.find(Agenda.class, id);

		tarea.setColor("green");
		try {
			em1.getTransaction().begin();
			em1.persist(tarea);
			em1.getTransaction().commit();

		} catch (Exception e) {
			grabado = false;
		}

		return grabado;
	}
	
	public static Boolean guardarTarea(CrearTareaForm crearTareaForm) {

		Boolean grabado = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrasladoDB");

		em1 = emf.createEntityManager();
		Agenda tarea = new Agenda();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

		// tarea.setCorreo(crearTareaForm.getCorreo());
		tarea.setDescripcion(crearTareaForm.getDescripcion());
		// tarea.setEstado(findEstado(Long.valueOf(1)));

		tarea.setTelefono(crearTareaForm.getTelefono());

		try {
			em1.getTransaction().begin();
			em1.persist(tarea);
			em1.getTransaction().commit();

		} catch (Exception e) {
			grabado = false;
		}

		return grabado;
	}
	
	public static boolean createPDF(SamFicha empresa,String horaInicio,UsuarioLogin user,Agenda agenda,List<Instalacion> inst,
			Integer folio,Integer anexo,String observaciones,String nombreCliente,String rutCliente,String cargo,String email,String url,boolean validaracc,String perifericos) throws DocumentException {
		boolean validar = true;
		EntityManagerFactory emf3 = Persistence.createEntityManagerFactory("samtech");
		em2 = emf3.createEntityManager();
		try
        	{	
	    	Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH;mm");
            String randomPDF = (new StringBuilder(String.valueOf(RandomStringUUID.obetenerUID()))).append(".pdf").toString();
            String nombrepdf = (new StringBuilder(String.valueOf(empresa.getFichLoginCliente()))).append("-").append(dateFormat.format(date)).append(".pdf").toString();
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(("/opt/tomcat/apache-tomcat-9.0.2/webapps/web/imgotsamtech/"+nombrepdf)));
            //PdfWriter.getInstance(document, new FileOutputStream((new StringBuilder("C:\\pdfs\\")).append(nombrepdf).toString()));

            document.addTitle("ORDEN DE TRABAJO");
            document.open();
            URL url1 = new URL("http://app.samtech.cl/web/imgotsamtech/logosmt.jpg");
            Image image2 = Image.getInstance(url1);
            image2.setWidthPercentage(40F);
            image2.scaleToFit(200F, 100F);
            image2.setAlignment(0);
            document.add(image2);
            Paragraph titulo = new Paragraph("Orden de Trabajo \n\n", FontFactory.getFont("arial", 19F, 1, BaseColor.BLACK));
            titulo.setAlignment(1);
            document.add(titulo);
            PdfPTable tableDatosCliente = new PdfPTable(4);
            Query querySamUsu = em2.createQuery("SELECT t.usu_cod_CV from SamUsuario t where t.usuLogin = :usuario");
            querySamUsu.setParameter("usuario", user.getUsername());
            String rutInstalador = "";
            String usu_rut = (String)querySamUsu.getSingleResult();
            if(usu_rut != null)
            {
                rutInstalador = usu_rut;
            }
            PdfPCell cell1 = new PdfPCell(new Paragraph("Nombre", FontFactory.getFont("arial", 9F)));
            PdfPCell cell2 = new PdfPCell(new Paragraph(empresa.getFichRazonSocial(), FontFactory.getFont("arial", 8F)));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Direccion", FontFactory.getFont("arial", 9F)));
            PdfPCell cell4 = new PdfPCell(new Paragraph(empresa.getFichCiudad(), FontFactory.getFont("arial", 8F)));
            PdfPCell cell5 = new PdfPCell(new Paragraph("Fecha", FontFactory.getFont("arial", 9F)));
            PdfPCell cell6 = new PdfPCell(new Paragraph(dateFormat.format(date), FontFactory.getFont("arial", 8F)));
            PdfPCell cell7 = new PdfPCell(new Paragraph("Hora de Inicio", FontFactory.getFont("arial", 9F)));
            PdfPCell cell8 = new PdfPCell(new Paragraph(horaInicio, FontFactory.getFont("arial", 8F)));
            tableDatosCliente.addCell(cell1).setBorder(0);
            tableDatosCliente.addCell(cell2).setBorder(0);
            tableDatosCliente.addCell(cell3).setBorder(0);
            tableDatosCliente.addCell(cell4).setBorder(0);
            tableDatosCliente.addCell(cell5).setBorder(0);
            tableDatosCliente.addCell(cell6).setBorder(0);
            tableDatosCliente.addCell(cell7).setBorder(0);
            tableDatosCliente.addCell(cell8).setBorder(0);
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Phrase(Chunk.NEWLINE));
            paragraph.add(new Phrase(Chunk.NEWLINE));
            document.add(tableDatosCliente);
            document.add(paragraph);
            PdfPTable tblActividad = new PdfPTable(4);
            PdfPTable tbl1 = new PdfPTable(2);
            PdfPCell btbl1 = null;
            if(agenda.getTitulo().equals("INSTALACION"))
            {
                btbl1 = new PdfPCell(new Paragraph("X", FontFactory.getFont("arial", 10F)));
                btbl1.setHorizontalAlignment(1);
                tbl1.addCell(btbl1);
            } else
            {
                btbl1 = new PdfPCell();
                tbl1.addCell(btbl1);
            }
            PdfPCell btbl2 = new PdfPCell(new Paragraph("Instalacion", FontFactory.getFont("arial", 8F)));
            btbl1.setFixedHeight(0.1F);
            tbl1.addCell(btbl2);
            PdfPTable tbl2 = new PdfPTable(2);
            PdfPCell ctbl1 = null;
            if(agenda.getTitulo().equals("RETIRO"))
            {
                ctbl1 = new PdfPCell(new Paragraph("X", FontFactory.getFont("arial", 10F)));
                ctbl1.setHorizontalAlignment(1);
                tbl2.addCell(ctbl1);
            }
            ctbl1 = new PdfPCell();
            PdfPCell ctbl2 = new PdfPCell(new Paragraph("Retiro", FontFactory.getFont("arial", 8F)));
            tbl2.addCell(ctbl1);
            tbl2.addCell(ctbl2);
            PdfPTable tbl3 = new PdfPTable(2);
            PdfPCell xtbl1 = null;
            if(agenda.getTitulo().equals("Intervencion"))
            {
                xtbl1 = new PdfPCell(new Paragraph("X", FontFactory.getFont("arial", 10F)));
                xtbl1.setHorizontalAlignment(1);
                tbl3.addCell(xtbl1);
            }
            xtbl1 = new PdfPCell();
            PdfPCell xtbl2 = new PdfPCell(new Paragraph("Intervencion", FontFactory.getFont("arial", 8F)));
            tbl3.addCell(xtbl1);
            tbl3.addCell(xtbl2);
            PdfPTable tbl4 = new PdfPTable(2);
            PdfPCell ftbl1 = null;
            if(agenda.getTitulo().equals("REVISION"))
            {
                ftbl1 = new PdfPCell(new Paragraph("X"));
                ftbl1.setHorizontalAlignment(1);
                tbl4.addCell(ftbl1);
            }
            ftbl1 = new PdfPCell();
            PdfPCell ftbl2 = new PdfPCell(new Paragraph("Revisión", FontFactory.getFont("arial", 8F)));
            tbl4.addCell(ftbl1);
            tbl4.addCell(ftbl2);
            PdfPTable tbl5 = new PdfPTable(2);
            PdfPCell ztbl1 = null;
            if(agenda.getTitulo().equals("Visita Fallida"))
            {
                ztbl1 = new PdfPCell(new Paragraph("X"));
            }
            ztbl1 = new PdfPCell();
            PdfPCell ztbl2 = new PdfPCell(new Paragraph("Visita Fallida", FontFactory.getFont("arial", 8F)));
            tbl5.addCell(ztbl1);
            tbl5.addCell(ztbl2);
            PdfPTable tbl6 = new PdfPTable(2);
            PdfPCell wtbl1 = null;
            if(agenda.getTitulo().equals("Inst. Demo"))
            {
                wtbl1 = new PdfPCell(new Paragraph("X"));
            }
            wtbl1 = new PdfPCell();
            PdfPCell wtbl2 = new PdfPCell(new Paragraph("Inst. Demo", FontFactory.getFont("arial", 8F)));
            tbl6.addCell(wtbl1);
            tbl6.addCell(wtbl2);
            PdfPTable tbl7 = new PdfPTable(2);
            PdfPCell htbl1 = null;
            if(agenda.getTitulo().equals("Migracion"))
            {
                htbl1 = new PdfPCell(new Paragraph("X"));
            }
            htbl1 = new PdfPCell();
            PdfPCell htbl2 = new PdfPCell(new Paragraph("Migracion", FontFactory.getFont("arial", 8F)));
            tbl7.addCell(htbl1);
            tbl7.addCell(htbl2);
            PdfPTable tbl8 = new PdfPTable(2);
            PdfPCell qtbl1 = null;
            if(agenda.getTitulo().equals("OTROS"))
            {
                qtbl1 = new PdfPCell(new Paragraph("X"));
            }
            qtbl1 = new PdfPCell();
            PdfPCell qtbl2 = new PdfPCell(new Paragraph("OTROS", FontFactory.getFont("arial", 8F)));
            tbl8.addCell(qtbl1);
            tbl8.addCell(qtbl2);
            tblActividad.addCell(tbl1);
            tblActividad.addCell(tbl2);
            tblActividad.addCell(tbl3);
            tblActividad.addCell(tbl4);
            tblActividad.addCell(tbl5);
            tblActividad.addCell(tbl6);
            tblActividad.addCell(tbl7);
            tblActividad.addCell(tbl8);
            document.add(tblActividad);
            Paragraph paragraph4 = new Paragraph();
            paragraph4.add(new Phrase(Chunk.NEWLINE));
            paragraph4.add(new Phrase(Chunk.NEWLINE));
            document.add(paragraph4);
            PdfPTable tableDispositivos = new PdfPTable(5);
            PdfPCell c1 = new PdfPCell(new Paragraph("ID: ", FontFactory.getFont("arial", 11F)));
            PdfPCell c2 = new PdfPCell(new Paragraph("Patente: ", FontFactory.getFont("arial", 11F)));
            PdfPCell c3 = new PdfPCell(new Paragraph("Año: ", FontFactory.getFont("arial", 11F)));
            PdfPCell c4 = new PdfPCell(new Paragraph("Color: ", FontFactory.getFont("arial", 11F)));
            PdfPCell c5 = new PdfPCell(new Paragraph("Marca: ", FontFactory.getFont("arial", 11F)));
            tableDispositivos.addCell(c1);
            tableDispositivos.addCell(c2);
            tableDispositivos.addCell(c3);
            tableDispositivos.addCell(c4);
            tableDispositivos.addCell(c5);
            int j = 0;
            for(int i = 0; i < inst.size(); i++)
            {
            	if(inst.get(i).getEstado() == 2)
            	
            	{
            		
            		if(j > 0) {
	            		PdfPCell filablanca = new PdfPCell(new Paragraph("-", FontFactory.getFont("arial", 10F)));
	            		filablanca.setHorizontalAlignment(1);
	            		filablanca.setColspan(5);
	            		tableDispositivos.addCell(filablanca);
            		}
            		tableDispositivos.addCell(new Paragraph(((Instalacion)inst.get(i)).getIdDevice(), FontFactory.getFont("arial", 8F)));
                    tableDispositivos.addCell(new Paragraph(((Instalacion)inst.get(i)).getPatente(), FontFactory.getFont("arial", 8F)));
                    tableDispositivos.addCell(new Paragraph(((Instalacion)inst.get(i)).getAnioVehiculo(), FontFactory.getFont("arial", 8F)));
                    tableDispositivos.addCell(new Paragraph(((Instalacion)inst.get(i)).getColorVehiculo(), FontFactory.getFont("arial", 8F)));
                    tableDispositivos.addCell(new Paragraph(((Instalacion)inst.get(i)).getMarcaVehiculo(), FontFactory.getFont("arial", 8F)));
                    //System.out.println(inst.get(i).getPerificos().size());
                    if(!inst.get(i).getPerificos().isEmpty() && inst.get(i).getPerificos().size() > 0) {
                    	tableDispositivos.addCell(new Paragraph(""));
                        tableDispositivos.addCell(new Paragraph("Periferico ", FontFactory.getFont("arial", 11F)));
                        tableDispositivos.addCell(new Paragraph("id periferico ", FontFactory.getFont("arial", 11F)));
                        tableDispositivos.addCell(new Paragraph("Modelo ", FontFactory.getFont("arial", 11F)));
                        tableDispositivos.addCell(new Paragraph("", FontFactory.getFont("arial", 11F)));
                    	List<Periferico> listado = inst.get(i).getPerificos();                 	
                    	for(Periferico p : listado) {                  		
                    		tableDispositivos.addCell(new Paragraph(""));
                    		tableDispositivos.addCell(new Paragraph(p.getNombre(),FontFactory.getFont("arial", 8F)));
                    		tableDispositivos.addCell(new Paragraph(p.getId_periferico(),FontFactory.getFont("arial", 8F)));
                    		String nameModelo = ValidacionLogService.findModeloPer(p.getModelo(), p.getIdSamFichaHardware());
                    		tableDispositivos.addCell(new Paragraph(nameModelo,FontFactory.getFont("arial", 8F)));
                    		tableDispositivos.addCell(new Paragraph("",FontFactory.getFont("arial", 8F)));
                    	
                    	}      
                    	
                    }
                    j++;
            		
            	}    
            }

            document.add(tableDispositivos);
            Paragraph paragraph11 = new Paragraph();
            paragraph11.add(new Phrase(Chunk.NEWLINE));
           
            /*document.add(paragraph11);
            List<SamFichaHardware> listFichaHardw = ClienteService.findAcessorios(folio, anexo);
            List<SamHardware> listaAccesorios = ClienteService.findAllAccesorios();
            PdfPTable tblPerifericos = new PdfPTable(5);
            PdfPCell pdfcp1 = new PdfPCell(new Paragraph("Perifericos", FontFactory.getFont("arial", 10F)));
            pdfcp1.setHorizontalAlignment(1);
            pdfcp1.setColspan(5);
            tblPerifericos.addCell(pdfcp1);
           	
           
            if(!validaracc) {
            	int contador = 0;
            	for(int i = 0; i < listaAccesorios.size(); i++)
                {
                    for(int j = 0; j < listFichaHardw.size(); j++)
                    {
                        if(listaAccesorios.get(i).getHarCodigo() == listFichaHardw.get(j).getFhHarCodigo())
                        {
                            PdfPCell pp = new PdfPCell(new Paragraph(listaAccesorios.get(i).getHarNombre(), FontFactory.getFont("arial", 10F)));
                            pp.setColspan(5);
                            tblPerifericos.addCell(pp);
                            contador++;
                        }
                    }

                }
              
                if(contador < 1)
                {dfP
                	PCell sp = new PdfPCell(new Paragraph("Sin perifericos", FontFactory.getFont("arial", 7F)));
                	sp.setHorizontalAlignment(1);
                	sp.setColspan(5);
                	tblPerifericos.addCell(sp);
                }
            }else{
            	if(perifericos != null) {
            		if (!perifericos.contains(",")) {
            			PdfPCell sp = new PdfPCell(new Paragraph(perifericos, FontFactory.getFont("arial", 7F)));
                        sp.setHorizontalAlignment(1);
                        sp.setColspan(5);
                        tblPerifericos.addCell(sp);
        			} else {
        				String parts[] = perifericos.split(",");
        				for (int i = 0; i < parts.length; i++) {
        					  PdfPCell pp = new PdfPCell(new Paragraph(parts[i], FontFactory.getFont("arial", 10F)));
                              pp.setColspan(5);
                              tblPerifericos.addCell(pp);
        				}
        			}
            	}else{
            		PdfPCell sp = new PdfPCell(new Paragraph("Sin perifericos", FontFactory.getFont("arial", 7F)));
                    sp.setHorizontalAlignment(1);
                    sp.setColspan(5);
                    tblPerifericos.addCell(sp);
                    
            	}
            }
            */
            
            //document.add(tblPerifericos);
            Paragraph paragraph3 = new Paragraph();
            paragraph3.add(new Phrase(Chunk.NEWLINE));
            paragraph3.add(new Phrase(Chunk.NEWLINE));
            document.add(paragraph3);
            PdfPTable tblObservaciones = new PdfPTable(1);
            
            PdfPCell tblobs = new PdfPCell(new Paragraph((new StringBuilder("Observaciones:")).append(observaciones	).toString(), FontFactory.getFont("arial", 8F)));
            tblobs.setFixedHeight(60F);
            tblObservaciones.addCell(tblobs);
            document.add(tblObservaciones);
            PdfPTable tableDatosTecnico = new PdfPTable(4);
            Paragraph paragraph1 = new Paragraph();
            paragraph1.add(new Phrase(Chunk.NEWLINE));
           
            document.add(paragraph1);
            PdfPCell dt1 = new PdfPCell(new Paragraph("DATOS DEL TECNICO", FontFactory.getFont("arial", 10F)));
            PdfPCell dt2 = new PdfPCell(new Paragraph("Nombre:", FontFactory.getFont("arial", 8F)));
            PdfPCell dtnombre = new PdfPCell(new Paragraph(user.getNombre() + user.getApellidos(), FontFactory.getFont("arial", 8F)));
            PdfPCell dt3 = new PdfPCell(new Paragraph("Rut: ", FontFactory.getFont("arial", 8F)));
            PdfPCell dtrut = new PdfPCell(new Paragraph(rutInstalador, FontFactory.getFont("arial", 8F)));
            dt1.setColspan(4);
            dt1.setHorizontalAlignment(1);
            dt2.setBorder(7);
            dtnombre.setBorder(3);
            dtnombre.setHorizontalAlignment(0);
            dt3.setHorizontalAlignment(2);
            dt3.setBorder(3);
            dtrut.setBorder(11);
            tableDatosTecnico.addCell(dt1);
            tableDatosTecnico.addCell(dt2);
            tableDatosTecnico.addCell(dtnombre);
            tableDatosTecnico.addCell(dt3);
            tableDatosTecnico.addCell(dtrut);
            document.add(tableDatosTecnico);
            PdfPTable tableDatosClienteAcep = new PdfPTable(4);
            Paragraph paragraph2 = new Paragraph();
            paragraph2.add(new Phrase(Chunk.NEWLINE));
            document.add(paragraph2);
            PdfPCell cl1 = new PdfPCell(new Paragraph("ACEPTACION DEL CLIENTE\t", FontFactory.getFont("arial", 10F)));
            PdfPCell cl2 = new PdfPCell(new Paragraph("Nombre:", FontFactory.getFont("arial", 8F)));
            PdfPCell clnombre = new PdfPCell(new Paragraph(nombreCliente, FontFactory.getFont("arial", 8F)));
            PdfPCell cl3 = new PdfPCell(new Paragraph("Rut: ", FontFactory.getFont("arial", 8F)));
            PdfPCell clrut = new PdfPCell(new Paragraph(rutCliente, FontFactory.getFont("arial", 8F)));
            PdfPCell cl4 = new PdfPCell(new Paragraph("Cargo: ", FontFactory.getFont("arial", 8F)));
            PdfPCell clcargo = new PdfPCell(new Paragraph(cargo, FontFactory.getFont("arial", 8F)));
            cl1.setColspan(4);
            cl1.setHorizontalAlignment(1);
            cl2.setBorder(7);
            clnombre.setBorder(3);
            clnombre.setHorizontalAlignment(0);
            cl3.setHorizontalAlignment(2);
            cl3.setBorder(3);
            clrut.setBorder(11);
            cl4.setBorder(7);
            clcargo.setBorder(3);
            clcargo.setHorizontalAlignment(0);
            tableDatosClienteAcep.addCell(cl1);
            tableDatosClienteAcep.addCell(cl2);
            tableDatosClienteAcep.addCell(clnombre);
            tableDatosClienteAcep.addCell(cl3);
            tableDatosClienteAcep.addCell(clrut);
            tableDatosClienteAcep.addCell(cl4);
            tableDatosClienteAcep.addCell(clcargo);
            document.add(tableDatosClienteAcep);
            Paragraph pg = new Paragraph();
            pg.add(new Phrase(Chunk.NEWLINE));
            document.add(pg);
            
			Image image = Image.getInstance(url);
            image.setWidthPercentage(35F);
            image.scaleToFit(220F, 430F);
            image.setAlignment(1);
            document.add(image);
            document.close(); 
            String mail = "";
            if(!email.equals("")){
            	mail = ","+email;
            }
            SamUsuario sam_usu = ClienteService.findSam_usuario(empresa.getFichUsuCodigo());
            System.out.println(sam_usu.getUsuMail());
            String mailEje = "";
            if(!sam_usu.getUsuMail().equals("")) {
            	mailEje = sam_usu.getUsuMail()+",";
            }
            sendMail.enviarCorreo("Comprobante trabajo finalizado en "+empresa.getFichRazonSocial()+" el "+dateFormat.format(date)+" por "+user.getNombre() +" "+user.getApellidos()+" ", "Estimado(a) "+empresa.getFichRazonSocial(),mailEje+"g.pichara@samtech.cl,c.ferrada@samtech.cl,r.lagos@samtech.cl,cdtsamtech@samtech.cl, m.rivas@samtech.cl,s.barrales@samtech.cl,m.perez@samtech.cl,g.gonzalez@samtech.cl"+mail, nombrepdf,user.getNombre() +" "+user.getApellidos());
        }
        catch(FileNotFoundException e)
        {
        	validar = false;
        
        }
        catch(IOException io)
        {
        	validar = false;
          
        }
		return validar;
	}
	
}
