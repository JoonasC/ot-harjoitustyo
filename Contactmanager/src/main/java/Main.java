import javafx.application.Application;
import javafx.stage.Stage;
import routing.Router;
import utils.PathUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
        PathUtils.ensureDataDirExists();
        new Router(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
