package org.fcuevas.carro.modelo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/*Esta anotación se utiliza comúnmente con Java Beans en aplicaciones Jakarta EE/CDI.
* Si la clase tiene una anotación como @Named o @Inject, y está dentro de un entorno habilitado para
* CDI (por ejemplo, hay un archivo beans.xml en WEB-INF), sí, se convierte en un managed bean que puede
* ser inyectado o accedido en páginas JSP, JSF, o clases Java.*/
@SessionScoped
/*La anotación @Named permite que el bean sea accesible por nombre en EL (${})*/
@Named("carro")
public class Carro implements Serializable {
    private List<ItemCarro> items;

    /*@Inject
    private transient Logger logger;*/

    public Carro() {
        this.items = new ArrayList<>();
    }

    /*Anotaciones para ejecutar acciones al iniciar y destruir los beans, recordar que esta clase es un
    bean al tener la anotación @SessionScoped

    @PostConstruct
    public void inicializarCarro(){
        logger.info("Inicializando el carro de compras.");
    }

    @PreDestroy
    public void destruirCarro(){
        logger.info("Destruyendo el carro de compras.");
    }*/

    public List<ItemCarro> getItems() {
        return items;
    }

    public void addItem(ItemCarro itemCarro){
        if(items.contains(itemCarro)){
            Optional<ItemCarro> optionalItemCarro = items.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findFirst();
            ItemCarro i = optionalItemCarro.get();
            i.setCantidad(i.getCantidad() + 1);
        }else{
            this.items.add(itemCarro);
        }
    }

    public Integer getTotal(){
        return this.items.stream().mapToInt(i->i.getTotal()).sum();
    }
}
