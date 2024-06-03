package org.tree.pack;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Контроллер отвечающий за представление списка.
 */
@Path("/")
public class TreePresentationController {
    private Tree tree;

    /**
     * Запоминает дерево, с которым будет работать.
     * @param tree дерево, с которым будет работать контроллер.
     */
    public TreePresentationController(Tree tree) {
        this.tree = tree;
    }

    /**
     * Выводит HTML-страницу с деревом, ссылками на страницы редактирования и копкой добавления узла.
     * @return HTML-страница со списком.
     */
    @GET
    @Path("/")
    @Produces("text/html")
    public String getTree() {
        return tree.getTreeHTMLString();
    }

    /**
     * Выводит страничку для редактирования одного элемента.
     * @param itemId индекс узла дерева.
     * @return страничка для редактирования одного элемента.
     */
    @GET
    @Path("/edit/{id}")
    @Produces("text/html")
    public String getEditPage(@PathParam("id") int itemId) {
        String nodeName = tree.findNode(tree.getRootNode(), itemId).getName();
        String result =
                "<html>" +
                        "  <head>" +
                        "    <title>Редактирование узла дерева</title>" +
                        "  </head>" +
                        "  <body>" +
                        "    <h1>Редактирование узла дерева</h1>" +
                        "    <a href=\"/\">Назад</a>" +
                        "    <form method=\"post\" action=\"/edit/" + itemId + "\">" +
                        "      Значение:" +
                        "      <input type=\"text\" name=\"value\" value=\"" + nodeName +"\"/>" +
                        "      <input type=\"submit\" value=\"Изменить\"/>"+
                        "    </form>" +
                        "    <form method=\"post\" action=\"/add/" + itemId + "\">" +
                        "      Добавить дочерний узел с именем:" +
                        "      <input type=\"text\" name=\"value\" value=\"\"/>" +
                        "      <input type=\"submit\" value=\"Добавить\"/>"+
                        "  </body>" +
                        "</html>";
        if(itemId != 0){
            result += "    </form>" +
                    "    <form method=\"post\" action=\"/delete/" + itemId + "\">" +
                    "      <input type=\"submit\" value=\"УДАЛИТЬ УЗЕЛ\"/>"+
                    "    </form>" ;
        }
        return result;
    }

    /**
     * Редактирует узел дерева на основе полученных данных.
     * @param itemId индекс узла дерева.
     * @return перенаправление на основную страницу со списком.
     */
    @POST
    @Path("/edit/{id}")
    @Produces("text/html")
    public Response editNode(@PathParam("id") int itemId, @FormParam("value") String itemValue) {
        tree.changeNodeName(itemId, itemValue);
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }

    /**
     * Добавляет узел в дерево на основе полученных данных.
     * @param itemId индекс узла дерева.
     * @return перенаправление на страницу с редактированием выбранного ранее узла.
     */
    @POST
    @Path("/add/{id}")
    @Produces("text/html")
    public Response addNode(@PathParam("id") int itemId, @FormParam("value") String itemValue) {
        tree.addChild(itemId, itemValue);
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }

    /**
     * Удаляет узел из дерева.
     * @param itemId индекс узла дерева.
     * @return перенаправление на основную страницу со списком.
     */
    @POST
    @Path("/delete/{id}")
    @Produces("text/html")
    public Response deleteNode(@PathParam("id") int itemId, @FormParam("value") String itemValue) {
        tree.deleteChild(itemId);
        try {
            return Response.seeOther(new URI("/")).build();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Ошибка построения URI для перенаправления");
        }
    }
}


