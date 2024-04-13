import { Component } from '@angular/core';
import { Router } from "@angular/router";
import {
  AttachmentRestControllerService, Item,
  ItemCategoryRestControllerService,
  ItemRestControllerService,
  Order,
  OrderLine
} from "../../../../../libs/openapi/src";
import { CarouselAnimationEffect } from "@syncfusion/ej2-angular-navigations";
import { cilList, cilShieldAlt, cilCheckCircle, cilPlus, cilMinus } from '@coreui/icons';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.scss']
})
export class ItemDetailsComponent {
  icons = { cilList, cilShieldAlt, cilCheckCircle, cilPlus, cilMinus };
  private id: any;
  public carouselAnimation: CarouselAnimationEffect = 'Fade';
  public object: any = {}; // Provide initial value
  public imagesFile: any[] = []; // Provide initial value
  newItem: Item = {
    name: undefined,
    description: undefined,
    price: undefined,
    availability: undefined,
    quantity: 0,
    itemCategory: {
      id: undefined,
      code: undefined,
      description: undefined
    }
  };


  public isInCart: boolean = false;
  private cartKey = 'myCart';
  public myCart: OrderLine[] = [];
  public qte: any = 1 || undefined;
  public item!: OrderLine
  constructor(private route: Router, private _service: ItemRestControllerService, private attachementService: AttachmentRestControllerService, private itemCategoryRestControllerService: ItemCategoryRestControllerService) { }

  ngOnInit() {
    this.id = history.state.id;
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
      this.getAttachedList();

    } else {
      this.object = this.newItem;
    }
  }



  checkItemInCart(id: number | undefined) {
    //Retrieve item from cart if exist we return true else false
    this.myCart = JSON.parse(localStorage.getItem('myCart') || "") || [];
    const itemIndex = this.myCart.findIndex(item => item.item?.id === id);
    if (itemIndex !== -1) {
      this.qte = this.myCart[itemIndex].quantity
      this.isInCart = true;// Item found 
    }
    else this.isInCart = false; // Item not found
  }



  quantity(num: number) {
    this.qte = this.qte + num;
    this.updateItemInCart(this.id);
  }

  

  updateItemInCart(itemId: number) {
    const itemIndex = this.myCart.findIndex(item => item.item?.id === itemId);

    this.item = this.myCart[itemIndex];
    if (this.item != null || this.item != undefined) {
      this.item!.quantity = this.qte
    }

    this.myCart[itemIndex] = this.item; // Update the item
    localStorage.setItem('myCart', JSON.stringify(this.myCart)); // Update local storage
  }



  addToCart(item: Item): void {

    let orderLine: OrderLine = {
      item: item,
      quantity: this.qte,
    }

    if (orderLine.quantity && orderLine.item?.price) {
      orderLine.totalPrice = orderLine.item?.price * orderLine.quantity;
    }
    let res = localStorage.getItem(this.cartKey);
    if (res == null) {
      localStorage.setItem(this.cartKey, '[]');
    }
    const existingCart = JSON.parse(localStorage.getItem(this.cartKey) || "") || [];
    existingCart.push(orderLine);
    localStorage.setItem(this.cartKey, JSON.stringify(existingCart));
    this.checkItemInCart(item.id);
  }


  // Function to get the item by its index
  getItemByIndex(index: number): OrderLine {

    return this.myCart[index];

    //return null; // Index out of bounds or cart is empty
  }
























  load() {
    this._service.loadItem(this.id).subscribe((res: any) => {
      this.object = res;
      this.checkItemInCart(this.object.id);
    });
  }
  getAttachedList() {
    this.attachementService.getAttachmentByParentIdAttachment(this.object.id).subscribe((res: any) => {
      if (res != null) {
        this.imagesFile = res;
      } else {
        alert("Something went wrong!")
      }
    });
  }
}
