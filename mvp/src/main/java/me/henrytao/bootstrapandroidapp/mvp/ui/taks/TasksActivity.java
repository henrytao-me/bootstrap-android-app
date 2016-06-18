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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import me.henrytao.bootstrapandroidapp.mvp.R;
import me.henrytao.bootstrapandroidapp.mvp.model.Task;
import me.henrytao.bootstrapandroidapp.mvp.ui.base.BaseActivity;
import me.henrytao.bootstrapandroidapp.mvp.ui.base.MultiStateAdapter;

/**
 * Created by henrytao on 6/18/16.
 */
public class TasksActivity extends BaseActivity implements TasksContact.View {

  public static Intent newIntent(Context context) {
    return new Intent(context, TasksActivity.class);
  }

  private MultiStateAdapter mMultiStateAdapter;

  private TasksAdapter mTasksAdapter;

  private TasksPresenter mTasksPresenter;

  private FloatingActionButton vFabCreate;

  private RecyclerView vRecyclerView;

  private Toolbar vToolbar;

  @Override
  public void onTaskAdded(Task task) {
    mMultiStateAdapter.showListView();
    mTasksAdapter.add(task);
    vRecyclerView.scrollToPosition(mMultiStateAdapter.getItemCount() - 1);
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
    vRecyclerView.scrollToPosition(mMultiStateAdapter.getItemCount() - 1);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tasks);

    vToolbar = (Toolbar) findViewById(R.id.toolbar);
    vRecyclerView = (RecyclerView) findViewById(android.R.id.list);
    vFabCreate = (FloatingActionButton) findViewById(R.id.fab_create);

    setSupportActionBar(vToolbar);

    mTasksAdapter = new TasksAdapter();
    mMultiStateAdapter = new MultiStateAdapter(mTasksAdapter);
    vRecyclerView.setAdapter(mMultiStateAdapter);
    vRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    mTasksPresenter = new TasksPresenter(this);
    mTasksPresenter.start();

    vFabCreate.setOnClickListener(v -> mTasksPresenter.createTask(
        String.format(Locale.US, "Title %d", new Date().getTime()),
        String.format(Locale.US, "Description %d", new Date().getTime())));
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mTasksPresenter.stop();
  }
}
