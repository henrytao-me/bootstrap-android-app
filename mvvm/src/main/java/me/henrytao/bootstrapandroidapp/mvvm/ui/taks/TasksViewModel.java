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

package me.henrytao.bootstrapandroidapp.mvvm.ui.taks;

import android.support.annotation.NonNull;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import me.henrytao.bootstrapandroidapp.mvvm.model.Task;
import me.henrytao.bootstrapandroidapp.mvvm.ui.base.BaseViewModel;

/**
 * Created by henrytao on 6/18/16.
 */
public class TasksViewModel extends BaseViewModel {

  private final Listener mListener;

  public TasksViewModel(@NonNull Listener listener) {
    mListener = listener;
  }

  public void loadTasks() {
    mListener.showLoadingView();
    // TODO: retrieve tasks from server
    mListener.showEmptyView();
  }

  public void onCreateTaskClick() {
    Task task = new Task(
        UUID.randomUUID().toString(),
        String.format(Locale.US, "Title %d", new Date().getTime()),
        String.format(Locale.US, "Description %d", new Date().getTime()));
    // TODO: store task to database or push task to server
    mListener.onTaskAdded(task);
  }

  public interface Listener {

    void onTaskAdded(Task task);

    void showEmptyView();

    void showLoadingView();

    void showTasks(List<Task> tasks);
  }
}
