package org.scoula.todo;

import org.scoula.lib.cli.App;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;
import org.scoula.todo.command.*;
import org.scoula.todo.service.TodoService;

public class TodoApp extends App {
    TodoService service = new TodoService();

    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);

        /*menu.add(new MenuItem("목록", new PrintTodoCommand()));
        menu.add(new MenuItem("상세", new DetailTodoCommand()));
        menu.add(new MenuItem("추가", new AddTodoCommand()));
        menu.add(new MenuItem("수정", new UpdateTodoCommand()));
        menu.add(new MenuItem("삭제", new DeleteTodoCommand()));*/

        menu.add(new MenuItem("목록", service::printTodoList));
        menu.add(new MenuItem("상세", service::detailTodo));
        menu.add(new MenuItem("추가", service::addTodo));
        menu.add(new MenuItem("수정", service::updateTodo));
        menu.add(new MenuItem("삭제", service::deleteTodo));
    }

    public static void main(String[] args) {
        App app = new TodoApp();
        app.run();
    }
}
