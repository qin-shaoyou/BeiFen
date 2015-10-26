/*
 * Copyright 2015 chenupt
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

package com.huanying;

/**
 * Created by chenupt@gmail.com on 2015/2/13.
 * Description :
 *
 * Your item view should implement this so you could bind item view
 * with its data if you have not extended {@link github.chenupt.multiplemodel.BaseItemView}.
 */
public interface IItemView<T> {

    public void bindView(ItemEntity<T> model);

}
