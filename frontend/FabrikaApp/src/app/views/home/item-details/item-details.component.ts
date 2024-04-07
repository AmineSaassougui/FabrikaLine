import { Component } from '@angular/core';
import { Router } from "@angular/router";
import {
  AttachmentRestControllerService, Item,
  ItemCategoryRestControllerService,
  ItemRestControllerService
} from "../../../../../libs/openapi/src";
import { CarouselAnimationEffect } from "@syncfusion/ej2-angular-navigations";
import { cilList, cilShieldAlt, cilCheckCircle } from '@coreui/icons';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.scss']
})
export class ItemDetailsComponent {
  icons = { cilList, cilShieldAlt, cilCheckCircle };
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
  load() {
    this._service.load5(this.id).subscribe((res: any) => {
      this.object = res;
    });
  }
  getAttachedList() {
    this.attachementService.getAttachmentByParentId(this.object.id).subscribe((res: any) => {
      if (res != null) {
        this.imagesFile = res;
      } else {
        alert("Something went wrong!")
      }
    });
  }
}
