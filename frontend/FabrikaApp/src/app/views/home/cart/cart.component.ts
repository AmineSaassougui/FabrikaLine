import { Component, OnInit } from '@angular/core';
import { Item, OrderLine } from 'libs/openapi/src';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  myItems : OrderLine[] = [];
  subTotal: any = 0;
  constructor() { }

  ngOnInit() {
  this.getCartItems();
  }

  getCartItems() {
    this.myItems = JSON.parse(localStorage.getItem('myCart')  || "") || [];
    if (this.myItems.length != 0) {
      this.calculateSubTotal();
    }
}

clearCart(): void {
    localStorage.setItem('myCart', '[]');
    
    this.getCartItems();
}

calculateSubTotal(){
  for (let item of this.myItems) {
    if (item.quantity && item.item?.price) {
      this.subTotal = this.subTotal + item?.totalPrice
    }
  }
}
}
