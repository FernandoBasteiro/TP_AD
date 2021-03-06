package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controladores.HibernateUtil;
import entities.CantoEntity;
import excepciones.ComunicacionException;
import negocio.Canto;

public class CantoDAO {

	private static CantoDAO instancia;

	private CantoDAO() {}

		
		public static CantoDAO getInstancia() {
			if (instancia == null) {
				instancia = new CantoDAO();
			}
			return instancia;
		}	
		
		public Integer crear(Canto c) {
			CantoEntity ce = new CantoEntity(c.isQuerido(), c.getTipoCanto(), c.getCantante());
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			Integer numero = (Integer)session.save(ce);
			session.getTransaction().commit();
			session.close();
			return numero;
		}
		
		public void grabar(Canto c) {
			CantoEntity ce = new CantoEntity(c.getId(),c.isQuerido(), c.getTipoCanto(), c.getCantante());
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			session.saveOrUpdate(ce);
			session.getTransaction().commit();
			session.close();
		}
		
		public void borrar(Canto c) {
			CantoEntity ce = new CantoEntity(c.getId(),c.isQuerido(), c.getTipoCanto(), c.getCantante());
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(ce);
			session.getTransaction().commit();
			session.close();
		}
		
		public Canto toNegocio(CantoEntity ce) {
			Canto c = new Canto(ce.getCantante());
			c.setQuerido(ce.getQuerido());
			c.setTipoCanto(ce.getTipoCanto());
			c.setId(ce.getId());
			return c;
		}
		
		public CantoEntity toEntity(Canto c) {
			return null; //TODO
		}
}
