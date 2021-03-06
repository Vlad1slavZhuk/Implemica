package com;

import com.controller.Controller;
import com.model.Model;
import com.view.View;

/**
 * @author Vladyslav Zhuchkov (vlad1k.zhuchkov@gmail.com)
 * @see <a href="@see <a href="https://github.com/Vlad1slavZhuk/Implemica/tree/master/TheShortedPath/src/com">GitHub</a>">GitHub</a>
 */
public class Main {
    public static void main(String[] args){
        var model = new Model();
        var view = new View(model);
        var controller = new Controller(view, model);
        controller.start();
    }
}
