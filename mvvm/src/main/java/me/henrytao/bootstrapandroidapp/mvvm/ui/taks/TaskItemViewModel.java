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

import android.databinding.ObservableField;

import me.henrytao.bootstrapandroidapp.mvvm.model.Task;
import me.henrytao.bootstrapandroidapp.mvvm.ui.base.BaseViewModel;

/**
 * Created by henrytao on 6/18/16.
 */
public class TaskItemViewModel extends BaseViewModel {

  public ObservableField<String> description = new ObservableField<>();

  public ObservableField<String> title = new ObservableField<>();

  public TaskItemViewModel() {
  }

  public void bind(Task task) {
    title.set(task.getTitle());
    description.set(task.getDescription());
  }
}
