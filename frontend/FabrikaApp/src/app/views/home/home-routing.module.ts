import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {ItemViewComponent} from "./item-view/item-view.component";
import {ItemDetailsComponent} from "./item-details/item-details.component";
import { OrderListComponent } from './order/order-list.component';
import { OrderFormComponent } from './order/order-form.component';
import { CartComponent } from './cart/cart.component';

const routes: Routes = [
  {
    path: 'Cart',
    component: CartComponent,
    data: {
      title: 'Cart'
    }
  },
  {
    path: 'OrderList',
    component: OrderListComponent,
    data: {
      title: 'Order'
    }
  },
  {
    path: 'OrderForm',
    component: OrderFormComponent,
    data: {
      title: 'Order'
    }
  },
  {
    path: 'ItemView',
    component: ItemViewComponent,
    data: {
      title: 'Item'
    }
  },
  {
    path: 'ItemDetails',
    component: ItemDetailsComponent,
    data: {
      title: 'Item'
    }
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}
