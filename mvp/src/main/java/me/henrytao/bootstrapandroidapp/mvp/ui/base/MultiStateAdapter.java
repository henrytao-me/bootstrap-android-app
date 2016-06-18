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

package me.henrytao.bootstrapandroidapp.mvp.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.henrytao.bootstrapandroidapp.mvp.R;
import me.henrytao.recyclerview.RecyclerViewAdapter;
import me.henrytao.recyclerview.config.Constants;
import me.henrytao.recyclerview.holder.HeaderHolder;

/**
 * Created by henrytao on 6/18/16.
 */
public class MultiStateAdapter extends RecyclerViewAdapter {

  protected static final int HEADER_EMPTY = 1;

  protected static final int HEADER_LOADING = 0;

  public MultiStateAdapter(RecyclerView.Adapter baseAdapter) {
    super(2, 0, baseAdapter);
    reset();
  }

  @Override
  public void onBindFooterViewHolder(RecyclerView.ViewHolder holder, int index) {
    // do nothing
  }

  @Override
  public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int index) {
    // do nothing
  }

  @Override
  public RecyclerView.ViewHolder onCreateFooterViewHolder(LayoutInflater inflater, ViewGroup parent, int index) {
    return null;
  }

  @Override
  public RecyclerView.ViewHolder onCreateHeaderViewHolder(LayoutInflater inflater, ViewGroup parent, int index) {
    switch (index) {
      case HEADER_LOADING:
        return new HeaderHolder(inflater, parent, R.layout.view_holder_loading, true);
      case HEADER_EMPTY:
        return new HeaderHolder(inflater, parent, R.layout.view_holder_empty, true);
    }
    return null;
  }

  public void showEmptyView() {
    if (getVisibility(HEADER_EMPTY, Constants.Type.HEADER) == View.VISIBLE) {
      return;
    }
    setBaseAdapterEnabled(false);
    setVisibility(HEADER_LOADING, View.GONE, Constants.Type.HEADER);
    setVisibility(HEADER_EMPTY, View.VISIBLE, Constants.Type.HEADER);
  }

  public void showListView() {
    if (isBaseAdapterEnabled()) {
      return;
    }
    setBaseAdapterEnabled(true);
    setVisibility(HEADER_LOADING, View.GONE, Constants.Type.HEADER);
    setVisibility(HEADER_EMPTY, View.GONE, Constants.Type.HEADER);
  }

  public void showLoadingView() {
    if (getVisibility(HEADER_LOADING, Constants.Type.HEADER) == View.VISIBLE) {
      return;
    }
    setBaseAdapterEnabled(false);
    setVisibility(HEADER_LOADING, View.VISIBLE, Constants.Type.HEADER);
    setVisibility(HEADER_EMPTY, View.GONE, Constants.Type.HEADER);
  }

  private void reset() {
    setBaseAdapterEnabled(false);
    setVisibility(HEADER_LOADING, View.GONE, Constants.Type.HEADER);
    setVisibility(HEADER_EMPTY, View.GONE, Constants.Type.HEADER);
  }
}
