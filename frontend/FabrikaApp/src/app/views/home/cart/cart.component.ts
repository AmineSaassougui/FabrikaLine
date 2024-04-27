import { Component, OnInit } from '@angular/core';
import { cilCheckCircle, cilList, cilMinus, cilPlus, cilShieldAlt, cilDelete, cilRecycle, cilClosedCaptioning } from '@coreui/icons';
import { AttachmentRestControllerService, Item, OrderLine, OrderLineRestControllerService } from 'libs/openapi/src';
import { ItemQuantityObject } from './../../../../../libs/openapi/src/model/itemQuantityObject';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  icons = { cilList, cilShieldAlt, cilCheckCircle, cilPlus, cilMinus, cilDelete, cilClosedCaptioning };

  subTotal: any = 0;
  public myCart: any[] = [];
  public qte: any = 1 || undefined;
  public item!: OrderLine
  constructor(private attachementsService: AttachmentRestControllerService, private orderLineRestControllerService: OrderLineRestControllerService) { }

  ngOnInit() {
    this.getCartItems();
  }


  Order() {
    let orderLine : OrderLine[] = [];

    let res : ItemQuantityObject[] = [];


    
    for(let i of this.myCart ){
        let x : ItemQuantityObject = {itemId: i.item['id'], quantity: i.quantity}
        res.push(x);
    }
    this.orderLineRestControllerService.saveOrderLineCart(res).subscribe((data => {
      if (data != null) {
        alert('Votre commande à été enregistré avec succès! Consulter vos commandes') 
        this.clearCart();
      }
    }))




  }

  getCartItems() {
    this.myCart = JSON.parse(localStorage.getItem('myCart') || "") || [];
    if (this.myCart.length != 0) {
      this.calculateSubTotal();
      this.getImage(this.myCart)
    }
  }

  getImage(items: any[]) {
    for (let item of items) {
      let res = this.attachementsService.getAttachmentByParentIdAttachment(item.item.id).subscribe((data => {
        if (data != null) {
          item.coverPic = data[0].attachedFile;
        }
      }))

    }
  }

  clearCart(): void {
    localStorage.setItem('myCart', '[]');

    this.getCartItems();
  }

  calculateSubTotal() {
    this.subTotal = 0;
    for (let item of this.myCart) {

      if (item.quantity && item.item?.price) {
        item.totalPrice = item.item?.price * item.quantity;
      }
      if (item.totalPrice) {
        this.subTotal = this.subTotal + item?.totalPrice
      }
    }
  }


  removeItem(itemId: number | undefined) {
    this.removeItemById(itemId)
  }

  removeItemById(itemId: number | undefined) {
    const itemIndex = this.myCart.findIndex(item => item.item?.id === itemId);
    if (itemIndex !== -1) {
      this.myCart.splice(itemIndex, 1); // Remove the item
      localStorage.setItem('myCart', JSON.stringify(this.myCart));
      this.getCartItems();
    }
  }

  // Function to get the item by its index
  getItemByIndex(index: number): OrderLine {
    return this.myCart[index];
  }



  quantity(num: number, itemId?: number) {
    this.qte = this.getItemByIndex(this.myCart.findIndex(item => item.item?.id === itemId)).quantity;
    this.qte = this.qte + num;
    this.updateItemInCart(itemId);
  }



  updateItemInCart(itemId?: number) {
    const itemIndex = this.myCart.findIndex(item => item.item?.id === itemId);

    this.item = this.myCart[itemIndex];
    if (this.item != null || this.item != undefined) {
      this.item!.quantity = this.qte
      this.calculateSubTotal();
    }

    this.myCart[itemIndex] = this.item; // Update the item
    localStorage.setItem('myCart', JSON.stringify(this.myCart)); // Update local storage
  }


}


