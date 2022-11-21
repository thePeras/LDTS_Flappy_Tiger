package feup.ldts.tanktrouble.states;

import feup.ldts.tanktrouble.controller.Controller;
import feup.ldts.tanktrouble.controller.MenuController;
import feup.ldts.tanktrouble.model.Menu;
import feup.ldts.tanktrouble.viewer.MenuViewer;
import feup.ldts.tanktrouble.viewer.Viewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
