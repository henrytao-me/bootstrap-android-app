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

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import me.henrytao.bootstrapandroidapp.mvvm.R;
import me.henrytao.bootstrapandroidapp.mvvm.databinding.ActivityTasksBinding;
import me.henrytao.bootstrapandroidapp.mvvm.model.Task;
import me.henrytao.bootstrapandroidapp.mvvm.ui.base.BaseActivity;
import me.henrytao.bootstrapandroidapp.mvvm.ui.base.MultiStateAdapter;

/**
 * Created by henrytao on 6/18/16.
 */
public class TasksActivity extends BaseActivity implements TasksViewModel.Listener {

  public static Intent newIntent(Context context) {
    return new Intent(context, TasksActivity.class);
  }

  private ActivityTasksBinding mBinding;

  private MultiStateAdapter mMultiStateAdapter;

  private TasksAdapter mTasksAdapter;

  private TasksViewModel mViewModel;

  @Override
  public void onTaskAdded(Task task) {
    mMultiStateAdapter.showListView();
    mTasksAdapter.add(task);
    mBinding.list.scrollToPosition(mMultiStateAdapter.getItemCount() - 1);
  }

  @Override
  public void showEmptyView() {
    mMultiStateAdapter.showEmptyView();
  }

  @Override
  public void showLoadingView() {
    mMultiStateAdapter.showLoadingView();
  }

  @Override
  public void showTasks(List<Task> tasks) {
    mMultiStateAdapter.showListView();
    mTasksAdapter.add(tasks);
    mBinding.list.scrollToPosition(mMultiStateAdapter.getItemCount() - 1);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mViewModel = new TasksViewModel(this);
    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_tasks);
    mBinding.setViewModel(mViewModel);

    setSupportActionBar(mBinding.toolbar);

    mTasksAdapter = new TasksAdapter();
    mMultiStateAdapter = new MultiStateAdapter(mTasksAdapter);
    mBinding.list.setAdapter(mMultiStateAdapter);
    mBinding.list.setLayoutManager(new LinearLayoutManager(this));

    mViewModel.loadTasks();
  }
}
