package remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import controladores.AdministradorGrupo;
import controladores.AdministradorJugador;
import dto.GrupoDTO;
import dto.InvitacionDTO;
import dto.JugadorDTO;
import dto.ParejaDTO;
import excepciones.ComunicacionException;
import excepciones.LoggedInException;
import interfaces.InterfaceRemota;

public class ObjetoRemoto extends UnicastRemoteObject implements InterfaceRemota {

	private static final long serialVersionUID = 8384110999673649178L;

	public ObjetoRemoto() throws RemoteException {}

	@Override
	public void crearJugador(JugadorDTO jugador) throws ComunicacionException {
		AdministradorJugador.getInstancia().crearJugador(jugador);
	}

	@Override
	public void login(JugadorDTO jugador) throws ComunicacionException {
		AdministradorJugador.getInstancia().login(jugador);
	}

	@Override
	public void logout(JugadorDTO jugador) throws LoggedInException, ComunicacionException {
		AdministradorJugador.getInstancia().logout(jugador);
	}

	@Override
	public void jugarLibreIndividual(JugadorDTO jugador) throws LoggedInException, ComunicacionException {
		AdministradorJugador.getInstancia().jugarLibreIndividual(jugador);
	}

	@Override
	public void jugarLibrePareja(JugadorDTO remitente, String invitado) throws LoggedInException, ComunicacionException {
		AdministradorJugador.getInstancia().jugarLibrePareja(remitente, invitado);
	}

	@Override
	public ArrayList<InvitacionDTO> listarInvitacionesPendientes(JugadorDTO jugador) throws LoggedInException, ComunicacionException {
		return AdministradorJugador.getInstancia().listarInvitacionesPendientes(jugador);
	}

	@Override
	public void aceptarInvitacion(JugadorDTO jugador, InvitacionDTO invitacion) throws LoggedInException, ComunicacionException {
		AdministradorJugador.getInstancia().aceptarInvitacion(jugador, invitacion);
	}

	@Override
	public void rechazarInvitacion(JugadorDTO jugador, InvitacionDTO invitacion) throws LoggedInException, ComunicacionException {
		AdministradorJugador.getInstancia().rechazarInvitacion(jugador, invitacion);
	}

	@Override
	public ArrayList<JugadorDTO> listarTopTen(Integer categoria) throws ComunicacionException {
		return AdministradorJugador.getInstancia().listarTopTen(categoria);
	}

	@Override
	public JugadorDTO buscarJugadorDTO(String apodo) throws ComunicacionException {
		return AdministradorJugador.getInstancia().buscarJugadorDTO(apodo);
	}

	@Override
	public void crearGrupo(JugadorDTO admin, String nombre) throws LoggedInException, ComunicacionException {
		AdministradorGrupo.getInstancia().crearGrupo(admin, nombre);
	}

	@Override
	public void buscarGrupoDTO(Integer id) throws ComunicacionException {
		AdministradorGrupo.getInstancia().buscarGrupoDTO(id);
	}

	@Override
	public void agregarJugadorAGrupo(JugadorDTO admin, GrupoDTO grupo, String apodo) throws LoggedInException, ComunicacionException {
		AdministradorGrupo.getInstancia().agregarJugadorAGrupo(admin, grupo, apodo);
	}

	@Override
	public void eliminarJugadorDeGrupo(JugadorDTO admin, GrupoDTO grupo, JugadorDTO jugador) throws LoggedInException, ComunicacionException {
		AdministradorGrupo.getInstancia().eliminarJugadorDeGrupo(admin, grupo, jugador);
	}

	@Override
	public void crearPareja(JugadorDTO admin, GrupoDTO grupo, JugadorDTO jugador1, JugadorDTO jugador2) throws LoggedInException, ComunicacionException {
		AdministradorGrupo.getInstancia().crearPareja(admin, grupo, jugador1, jugador2);
	}

	@Override
	public void crearPartida(JugadorDTO admin, GrupoDTO grupo, ParejaDTO pareja1, ParejaDTO pareja2) throws LoggedInException, ComunicacionException {
		AdministradorGrupo.getInstancia().crearPartida(admin, grupo, pareja1, pareja2);
	}

	@Override
	public ArrayList<JugadorDTO> calcularRankingCerrado(GrupoDTO grupo) throws ComunicacionException {
		return AdministradorGrupo.getInstancia().calcularRankingCerrado(grupo);
	}

}