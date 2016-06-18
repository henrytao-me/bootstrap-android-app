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

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import me.henrytao.bootstrapandroidapp.mvvm.R;
import me.henrytao.bootstrapandroidapp.mvvm.databinding.ViewHolderTaskItemBinding;
import me.henrytao.bootstrapandroidapp.mvvm.model.Task;

/**
 * Created by henrytao on 6/18/16.
 */
public class TaskItemViewHolder extends RecyclerView.ViewHolder {

  private final ViewHolderTaskItemBinding mBinding;

  private final TaskItemViewModel mViewModel;

  public TaskItemViewHolder(ViewGroup parent) {
    super(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_task_item, parent, false));
    mViewModel = new TaskItemViewModel();
    mBinding = DataBindingUtil.bind(itemView);
    mBinding.setViewModel(mViewModel);
  }

  public void bind(Task task) {
    mViewModel.bind(task);
  }
}
