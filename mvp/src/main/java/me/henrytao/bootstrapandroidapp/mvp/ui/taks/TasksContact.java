/*
 * Copyright 2016 "Henry Tao <hi@henrytao.me>"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.henrytao.bootstrapandroidapp.mvp.ui.taks;

import java.util.List;

import me.henrytao.bootstrapandroidapp.mvp.model.Task;
import me.henrytao.bootstrapandroidapp.mvp.ui.base.BasePresenter;
import me.henrytao.bootstrapandroidapp.mvp.ui.base.BaseView;

/**
 * Created by henrytao on 6/18/16.
 */
public interface TasksContact {

  interface Presenter extends BasePresenter {

    void createTask(String title, String description);

    void loadTasks();
  }

  interface View extends BaseView<Presenter> {

    void onTaskAdded(Task task);

    void showEmptyView();

    void showLoadingView();

    void showTasks(List<Task> tasks);
  }
}