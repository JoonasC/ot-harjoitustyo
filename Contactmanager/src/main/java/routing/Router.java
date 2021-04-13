package routing;

import controllers.Controller;
import controllers.LoginController;
import javafx.stage.Stage;
import models.LoginModel;
import models.Model;
import views.LoginView;
import views.View;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Router {
    private final Stage mainStage;

    private final List<View<Controller<?>, Model<?>>> views = new ArrayList<>();
    private final List<Controller<Model<?>>> controllers = new ArrayList<>();
    private final List<Model<View<?, ?>>> models = new ArrayList<>();

    public Router(Stage mainStage) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.mainStage = mainStage;

        instantiateViewsControllersAndModels(LoginView.class, LoginController.class, LoginModel.class);

        navigateTo(LoginView.class);
    }

    public void navigateTo(Class<?> viewClass) {
        if (!viewClass.getSuperclass().getCanonicalName().equals(View.class.getCanonicalName())) {
            throw new IllegalArgumentException("Router can only navigate to views");
        }

        for (View<Controller<?>, Model<?>> view : views) {
            if (viewClass.isInstance(view)) {
                renderView(view);
            }
        }
    }

    private void renderView(View<Controller<?>, Model<?>> view) {
        mainStage.hide();
        mainStage.setTitle(String.format("Contactmanager - %s", view.getWindowTitleSuffix()));
        mainStage.setWidth(view.getWindowWidth());
        mainStage.setHeight(view.getWindowHeight());
        mainStage.setScene(view.getScene());
        mainStage.centerOnScreen();
        mainStage.show();
    }

    @SuppressWarnings("unchecked")
    private void instantiateViewsControllersAndModels(Class<?> view, Class<?> controller, Class<?> model) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        View<Controller<?>, Model<?>> viewInstance = (View<Controller<?>, Model<?>>) view.getConstructor(this.getClass()).newInstance(this);
        Controller<Model<?>> controllerInstance = (Controller<Model<?>>) controller.getConstructor().newInstance();
        Model<View<?, ?>> modelInstance = (Model<View<?, ?>>) model.getConstructor().newInstance();

        viewInstance.setController(controllerInstance);
        viewInstance.setModel(modelInstance);
        controllerInstance.setModel(modelInstance);
        modelInstance.setView(viewInstance);

        views.add(viewInstance);
        controllers.add(controllerInstance);
        models.add(modelInstance);
    }
}