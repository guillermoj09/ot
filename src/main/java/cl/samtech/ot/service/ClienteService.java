package cl.samtech.ot.service;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import cl.samtech.ot.UsuarioLogin;
import model.Cliente;
import model.Device;
import model.Faenas;
import model.MM_Faena_Vehiculo;
import model.PasoFaena;
import model.PasoUsuario;
import model.SamFichaHardware;
import model.SamHardware;
import model.SamUsuario;

public class ClienteService {


    private static EntityManager em;
    private static EntityManager em1;
    private static EntityManager em2;
    private static EntityManager em3;
    private static EntityManager em4;
    private static EntityManager em5;
    private static EntityManager em6;
    private static EntityManager em7;
    private static EntityManager em8;
    private static EntityManager em9;
    private static EntityManager em10;
    private static EntityManager em11;

	
	
	public static Boolean verificarGPSCliente(String idGps) {
		boolean validador = true;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em8 = emf.createEntityManager();

		List<PasoUsuario> list = null;
		Query query = em8.createQuery("SELECT p FROM PasoUsuario p where p.paten = :id_gps");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("id_gps", idGps);
		list = query.getResultList();
		
		if(list.isEmpty() || list == null) {
			validador = false;
		}
		
		return validador;
	}
	
	final static Logger logger = Logger.getLogger(InstalacionService.class);

	public static List<Cliente> allClientes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em = emf.createEntityManager();

		Query query = em.createQuery("select c from Cliente c where (c.estado in (1,5)) order by c.nombre");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		List<Cliente> listaCliente = (List<Cliente>) query.getResultList();

		return listaCliente;

	}

	public static List<Faenas> allFaenas() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em = emf.createEntityManager();

		TypedQuery<Faenas> allfaenas = em.createNamedQuery("Faenas.findAll", Faenas.class);
		List<Faenas> faenas = allfaenas.getResultList();
		return faenas;

	}
	
	public static Integer IdOtNum() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("samtech");
		em = emf.createEntityManager();
		Query query = em.createQuery("SELECT MAX(s.ottNum) FROM Sam_OT s");
		Integer num_ot = (Integer) query.getSingleResult();
		Integer ott_num  = num_ot+1;
		return ott_num;
	}
	
	public static boolean limpiarAsignacionCliente(String id_gps, UsuarioLogin usuario) {
		
		boolean validar= false;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em7 = emf.createEntityManager();
		em = emf.createEntityManager();
		em1 = emf.createEntityManager();


		StoredProcedureQuery query = em7.createStoredProcedureQuery("SP_EliminaAsignacion_pass");

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);

		query.setParameter(1, id_gps);
		query.setParameter(2, usuario.getUsername());
		query.setParameter(3, usuario.getPassword());
		query.execute();
		
		StoredProcedureQuery query2 = em.createStoredProcedureQuery("PA_modificacion_historico_pass");
		query2.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);		
		query2.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(13, String.class, ParameterMode.IN);
		query2.registerStoredProcedureParameter(14, String.class, ParameterMode.IN);


		query2.setParameter(1, id_gps);
		query2.setParameter(2, "");
		query2.setParameter(3, "");
		query2.setParameter(4, "");
		query2.setParameter(5, "");
		query2.setParameter(6, "");
		query2.setParameter(7, "");
		query2.setParameter(8, "");
		query2.setParameter(9, "");
		query2.setParameter(10, usuario.getUsername());
		query2.setParameter(11, "Limpia Asignacion");
		query2.setParameter(12, "");
		query2.setParameter(13, usuario.getUsername());
		query2.setParameter(14, usuario.getPassword());
		query2.execute();
		
		try {
			em1.getTransaction().begin();
			em1.createNativeQuery("insert into MM_pagador_historial(pagador,pagador_ante,gps,usuario) values('N/A','Limpia Asignacion','"+id_gps+"','"+usuario.getUsername()+"')").executeUpdate();
			em1.getTransaction().commit();
			em1.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return true;
	}
	
	public static Boolean Actualiza_odo(String id_gps,String patente,double odo, double odo_ant,UsuarioLogin usuarioLogin) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em6 = emf.createEntityManager();

		StoredProcedureQuery query = em6.createStoredProcedureQuery("MM_P_Actualiza_odo_device_pass");

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
		
		query.setParameter(1, id_gps);
		query.setParameter(2, patente);
		query.setParameter(3, odo);
		query.setParameter(4, odo_ant);
		query.setParameter(5, usuarioLogin.getUsername());
		query.setParameter(6, usuarioLogin.getPassword());
		
		query.execute();
		em6.close();
		
		return true;
	}
	
	public static Boolean findClienteasignado(String idGps,String login_cliente) {
		boolean validador = true;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em8 = emf.createEntityManager();

		List<PasoUsuario> list = null;
		Query query = em8.createQuery("SELECT p FROM PasoUsuario p where p.paten = :id_gps and p.usuarioLogin = :login_cliente");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("id_gps", idGps);
		query.setParameter("login_cliente", login_cliente);
		list = query.getResultList();
		
		if(list.isEmpty() || list == null) {
			validador = false;
		}
		
		return validador;
	}
	
	public static Boolean verificarClienteAsignado(String cliente, String idGps) {
		boolean validador = true;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em8 = emf.createEntityManager();

		List<PasoUsuario> list = null;
		Query query = em8.createQuery("SELECT p FROM PasoUsuario p where p.usuarioLogin = :cliente AND p.patente = :id_gps");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("cliente", cliente);
		query.setParameter("id_gps", idGps);
		list = query.getResultList();
		
		if(list.isEmpty() || list == null) {
			validador = false;
		}
		
		return validador;
	}

	public static Integer IdSamUsuario(String username) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("samtech");
		em2 = emf.createEntityManager();
		Query queryId = em2.createQuery("SELECT s.usuCodigo FROM SamUsuario s where s.usuLogin = :nom");
		queryId.setParameter("nom", username);
		Integer id_usu = (Integer) queryId.getSingleResult();
		return id_usu;
	}
	
	public static SamUsuario findSam_usuario(Integer sam_codigo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("samtech");
		em2 = emf.createEntityManager();
		Query queryId = em2.createQuery("SELECT s FROM SamUsuario s where s.usuCodigo = :sam_codigo");
		queryId.setParameter("sam_codigo", sam_codigo);
		SamUsuario sam_usu = (SamUsuario) queryId.getSingleResult();
		return sam_usu;
	}

	public static Boolean agregarFaena(String id_gps, String empresa_perfil, String patente, UsuarioLogin userLogin) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em = emf.createEntityManager();

		StoredProcedureQuery query = em.createStoredProcedureQuery("MM_P_act_vehicle");

		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
		query.setParameter(1, id_gps);
		query.setParameter(3, empresa_perfil);
		query.setParameter(3, patente);
		query.setParameter(4, userLogin.getUsername());
		query.setParameter(5, userLogin.getPassword());
		query.execute();
		em.close();
		return true;
	}

	public static PasoFaena IdentificarFaena(String cliente_login) {

		PasoFaena resultado = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em3 = emf.createEntityManager();
		
		Query queryp = em3.createQuery("Select p FROM PasoFaena p where p.id.usuario = :usuario");
		queryp.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		queryp.setParameter("usuario", cliente_login);
		List<PasoFaena> pasofaena = queryp.getResultList();
		if (pasofaena != null && !pasofaena.isEmpty()) {
			for (PasoFaena f : pasofaena) {
				if (f.getId().getFaena().equals("principal")) {
					resultado = f;
					break;
				}
			}
			if (resultado == null) {
				resultado = pasofaena.get(0);
			}
		}
		return resultado;
	}

	public static Boolean asignar_faena_vehiculos(String id_gps, String login_cliente) {
		Boolean validar = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em1 = emf.createEntityManager();
		em5 = emf.createEntityManager();

		Query query2 = em5.createQuery("Select p FROM Cliente p where p.login = :cliente ");
		query2.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query2.setParameter("cliente", login_cliente);
		Cliente cliente = (Cliente) query2.getSingleResult();

		Query query = em1.createQuery("Select p FROM MM_Faena_Vehiculo p where p.FV_vehiculo = :id_gps ");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("id_gps", id_gps);
		List resultList = query.getResultList();
		// insert into paso_usuario
		// values('''+@p_usuario+''','''+@id_pet+''',0,0,0,0,0,'''+@id_pet+''','') ';

		PasoFaena PFaena = IdentificarFaena(login_cliente);

		if (resultList == null || resultList.isEmpty()) {
			Timestamp fecha = new Timestamp(System.currentTimeMillis());

			try {
				MM_Faena_Vehiculo mmfaena = new MM_Faena_Vehiculo();
				mmfaena.setFV_vehiculo(id_gps);
				mmfaena.setFV_cliente_propietario(cliente.getIdCliente());
				mmfaena.setFV_usuario_asigna(cliente.getLogin());
				mmfaena.setFV_faena(PFaena.getId().getIdPaso());
				mmfaena.setFV_fecha_asigna(fecha);
				em1.getTransaction().begin();
				em1.persist(mmfaena);
				em1.getTransaction().commit();
				em1.close();
			} catch (Exception e) {
				System.out.println(e);
				validar = false;
			}
		} else {
			validar = false;
		}
		return validar;
	}
	public static List<SamHardware> findAllAccesorios(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("samtech");
		em10 = emf.createEntityManager();
		Query query = em10.createQuery("Select s FROM SamHardware s where s.harTipHardware = 2 and s.harNombre <> '- - - Accesorios - - - '" );
		List<SamHardware> resultList = query.getResultList();
		return resultList;
	}

	
	public static List<SamFichaHardware> findAcessorios(Integer folio, Integer anexo){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("samtech");
		em9 = emf.createEntityManager();
		Query query = em9.createQuery("Select s FROM SamFichaHardware s where s.fhCodAnexo = :anexo and s.fhFichCodigo = :folio");
		query.setParameter("folio", folio);
		query.setParameter("anexo", anexo);
		List<SamFichaHardware> resultList = query.getResultList();
		return resultList;
	}
	
	 public static Boolean agregarHistoricoPass(Device device, UsuarioLogin usuario, String obs)
	    {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
	        em11 = emf.createEntityManager();
	        StoredProcedureQuery query = em11.createStoredProcedureQuery("PA_modificacion_historico_pass");
	        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(2,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(3,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(4,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(5,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(6,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(7,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(8,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(9,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(10,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(11,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(12,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(13,  String.class, ParameterMode.IN);
	        query.registerStoredProcedureParameter(14,  String.class, ParameterMode.IN);
	        
	        query.setParameter(1, device.getIdDevice());
	        query.setParameter(2, device.getMarcaCamion());
	        query.setParameter(3, device.getPatente());
	        query.setParameter(4, "");
	        query.setParameter(5, device.getUsuarioCamion());
	        query.setParameter(6, device.getFaena());
	        query.setParameter(7, device.getSn());
	        query.setParameter(8, device.getPhone());
	        query.setParameter(9, device.getInstalador());
	        query.setParameter(10, usuario.getUsername());
	        query.setParameter(11, obs);
	        query.setParameter(12, "Trabajo Terminado");
	        query.setParameter(13, usuario.getUsername());
	        query.setParameter(14, usuario.getPassword());
	        query.execute();
	        em11.close();
	        return Boolean.valueOf(true);
	    }

	public static Boolean agregarAsignacionCliente(String usuLogin, String id_gps) {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gpsf");
		em4 = emf.createEntityManager();
		boolean validar = true;
		Query query = em4.createQuery("Select p FROM PasoUsuario p where p.usuarioLogin = :p_usuario and p.patente= :id_gps ");
		query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
		query.setParameter("p_usuario", usuLogin);
		query.setParameter("id_gps", id_gps);
		List resultList = query.getResultList();
		// insert into paso_usuario
		// values('''+@p_usuario+''','''+@id_pet+''',0,0,0,0,0,'''+@id_pet+''','') ';
		if (resultList == null || resultList.isEmpty()) {
			try {
				PasoUsuario pasoUsu = new PasoUsuario();
				pasoUsu.setUsuarioLogin(usuLogin);
				pasoUsu.setPatente(id_gps);
				pasoUsu.setAdmin(0);
				pasoUsu.setCliAdmin(0);
				pasoUsu.setInvitado(0);
				pasoUsu.setVer(0);
				pasoUsu.setPaten(id_gps);
				em4.getTransaction().begin();
				em4.persist(pasoUsu);
				em4.getTransaction().commit();
				em4.close();
			} catch (Exception e) {
				System.out.println(e);
				validar = false;
			}
		} else {
			validar = false;
		}
		return validar;
	}

}
