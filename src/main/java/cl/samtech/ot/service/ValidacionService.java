package cl.samtech.ot.service;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import model.Instaladores_Device;
import model.TblValidacione;

public class ValidacionService {
	
	private static EntityManager em;
	private static EntityManager em1;
	private static EntityManager em2;
	private static EntityManager em3;
	
	final static Logger logger = Logger.getLogger(InstalacionService.class);
	
	
	public static Boolean crearTblValidadacion(Instaladores_Device insDev, Timestamp fecha, Integer ot,
			String observacion, String usu) {
		boolean validador = true;
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("gpsf");
		em1 = emf1.createEntityManager();
		try {
			TblValidacione tblvalidades = new TblValidacione();
			tblvalidades.setId_Instalador(insDev.getInstalador());
			tblvalidades.setId_Gps(insDev.getIdGps());
			tblvalidades.setId_Cdt("cdtsamtech");
			tblvalidades.setFechaBdd(fecha);
			tblvalidades.setFechaIngreso(fecha);
			tblvalidades.setTipoValidacion(1);
			tblvalidades.setOt(ot.intValue());
			tblvalidades.setConfirmada(1);
			tblvalidades.setIdAsistencia(1);
			tblvalidades.setVigencia(false);
			tblvalidades.setObservacion(
					(new StringBuilder(String.valueOf(usu))).append(": ").append(observacion).toString());
			em1.getTransaction().begin();
			em1.persist(tblvalidades);
			em1.getTransaction().commit();
			em1.close();
		} catch (Exception e) {
			System.out.println(e);
			validador = false;
		}
		return Boolean.valueOf(validador);
	}
	
	public static Boolean updateTblValidadacion(Instaladores_Device insDev, Timestamp fecha, String obs,String usu) {
		boolean validador = true;
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("gpsf");
		em1 = emf1.createEntityManager();
		try {
			Query query = em1.createQuery("SELECT i FROM TblValidacione i where i.id_Gps = :id_device and i.ot = :ot");
			query.setParameter("id_device", insDev.getIdGps());
			query.setParameter("ot", Integer.parseInt(insDev.getOt()));
			query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");
			TblValidacione tblvalidades = (TblValidacione) query.getResultList().get(0);
			tblvalidades.setId_Instalador(insDev.getInstalador());
			tblvalidades.setId_Gps(insDev.getIdGps());
			tblvalidades.setId_Cdt("cdtsamtech");
			tblvalidades.setFechaBdd(fecha);
			tblvalidades.setFechaIngreso(fecha);
			tblvalidades.setTipoValidacion(1);
			tblvalidades.setOt(Integer.parseInt(insDev.getOt()));
			tblvalidades.setConfirmada(1);
			tblvalidades.setIdAsistencia(1);
			tblvalidades.setVigencia(false);
			tblvalidades.setObservacion(
					(new StringBuilder(String.valueOf(usu))).append(": ").append(obs).toString());
			em1.getTransaction().begin();
			em1.persist(tblvalidades);
			em1.getTransaction().commit();
			em1.close();
		} catch (Exception e) {
			validador = false;
		}
		return validador;
	}

}
