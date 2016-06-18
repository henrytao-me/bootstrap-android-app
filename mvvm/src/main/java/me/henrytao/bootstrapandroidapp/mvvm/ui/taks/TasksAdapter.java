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

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.henrytao.bootstrapandroidapp.mvvm.model.Task;

/**
 * Created by henrytao on 6/18/16.
 */
public class TasksAdapter extends RecyclerView.Adapter<TaskItemViewHolder> {

  private final List<Task> mData;

  public TasksAdapter() {
    mData = new ArrayList<>();
  }

  @Override
  public int getItemCount() {
    return mData.size();
  }

  @Override
  public void onBindViewHolder(TaskItemViewHolder holder, int position) {
    holder.bind(mData.get(position));
  }

  @Override
  public TaskItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new TaskItemViewHolder(parent);
  }

  public void add(List<Task> tasks) {
    if (tasks == null || tasks.size() == 0) {
      return;
    }
    int count = mData.size();
    mData.addAll(tasks);
    notifyItemRangeInserted(count, tasks.size());
  }

  public void add(Task task) {
    if (task == null) {
      return;
    }
    mData.add(task);
    notifyItemInserted(mData.size() - 1);
  }
}
