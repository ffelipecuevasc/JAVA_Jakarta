package org.fcuevas.carro.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.fcuevas.carro.modelo.Carro;

//La anocatión @WebListener establece que esta clase sea reconocida como listener por Apache
@WebListener
/* Las interfaces ServletContextListener, HttpSessionListener y ServletRequestListener pertenecen al API
 * de eventos del ciclo de vida de una aplicación web. Usarlas te permite "escuchar" eventos importantes
 * del servidor y ejecutar lógica automáticamente cuando esos eventos ocurren.*/
public class CarroComprasAppListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

    /*La clase ServletContext juega un rol fundamental en las aplicaciones web Jakarta EE, ya que
    * representa el entorno global de la aplicación web en el servidor. Es como una "puerta de entrada"
    * para acceder a recursos compartidos, información de configuración y contexto general de toda la
    * aplicación.
    *
    * 🧠 ¿Qué es ServletContext?
    * Es un objeto único y global que se crea cuando se inicia la aplicación web y permanece activo
    * hasta que se detiene.*/
    private ServletContext sc;

    /*Interfaz ServletContextListener - Escucha eventos del inicio y destrucción de la aplicación web.
    * --------------------------------------------------------
    * ¿Para qué sirve?
    * - Inicializar recursos al arrancar la app (conexiones, logs, pools).
    * - Cargar datos iniciales.
    * - Liberar recursos cuando el servidor se detiene.*/
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.sc = sce.getServletContext();
        this.sc.log("Inicializando la aplicación.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.sc.log("Destruyendo la aplicación.");
    }

    /*Interfaz ServletRequestListener - Escucha cada solicitud HTTP (request) que entra o sale.
     * --------------------------------------------------------
     * ¿Para qué sirve?
     * - Medir tiempos de respuesta.
     * - Aplicar filtros de logging.
     * - Cargar/preparar datos antes de atender un request.*/
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        this.sc.log("Inicializando la solicitud HttpRequest.");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        this.sc.log("Destruyendo la solicitud HttpRequest.");
    }

    /*Interfaz HttpSessionListener - Escucha cuando se crea o destruye una sesión de usuario.
     * --------------------------------------------------------
     * ¿Para qué sirve?
     * - Contar usuarios conectados.
     * - Registrar actividad de sesión.
     * - Eliminar recursos o datos al cerrar sesión o expirar.*/
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        this.sc.log("Inicializando la sesión HttpSession.");

        /* Añadimos CDI y la clase Carro ahora está preparada como Java Bean para ser inyectada, por lo
        que ahora no es necesario el siguiente código Java:
        - Carro carro = new Carro();
        - HttpSession session = se.getSession();
        - session.setAttribute("carro", carro);*/
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        this.sc.log("Destruyendo la sesión HttpSession.");
    }
}
/*Hay otras interfaces importantes para manejar el ciclo de vida de la app web, tales como:
*
* 1) HttpSessionAttributeListener	    -> Para monitorear o validar datos agregados a la sesión
* 2) ServletRequestAttributeListener	-> Para observar atributos temporales en cada solicitud
* 3) HttpSessionBindingListener	        -> Cuando un objeto necesita reaccionar al agregarse/quitarse
*
* Estas interfaces te dan un control fino sobre lo que pasa dentro del ciclo de vida web de tu aplicación.
* Si estás construyendo una app más compleja (autenticación, multisesión, monitoreo), usarlas bien te permite
* mantenerla ordenada y profesional.*/