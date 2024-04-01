import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {ItemViewComponent} from "./item-view/item-view.component";

const routes: Routes = [
  {
    path: 'ItemView',
    component: ItemViewComponent,
    data: {
      title: 'Item'
    }
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}
