package org.tree.pack;

import org.tree.pack.TreePresentationController;
import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Web-приложение в котором регистрируются все ресурсы.
 */
public class RestAplication extends Application {

    private Tree tree = new Tree("root_name");

    public RestAplication() {
        tree.addChild("root_name", "child1");
        tree.addChild("root_name", "child2");
        tree.addChild("root_name", "child3");
        tree.addChild("child1", "child4");
        tree.addChild("child2", "child5");
        tree.addChild("child2", "child6");
        tree.addChild("child3", "child7");
    }

    /**
     * Возвращает список всех ресурсов web-приложения.
     * @return список всех ресурсов web-приложения.
     */
    @Override
    public Set<Object> getSingletons() {
        Set<Object> resources = new HashSet<>();
        resources.add(new TreePresentationController(tree));
        return resources;
    }
}