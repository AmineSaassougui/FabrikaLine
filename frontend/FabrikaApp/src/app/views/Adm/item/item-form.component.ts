import { Component, OnInit, ViewEncapsulation  } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { AttachmentRestControllerService, ItemRestControllerService, ItemCategoryRestControllerService } from 'libs/openapi/src';
import { Item } from './../../../../../libs/openapi/src/model/item';
import { CarouselAnimationEffect } from '@syncfusion/ej2-angular-navigations';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css'],
  encapsulation: ViewEncapsulation.None

})
export class ItemFormComponent implements OnInit {
  object: any = {}; // Initialize object with empty object
  ok = true;
  categoryId: number = 0;
  categoryName: any = "Catégorie article";
  slides: any[] = [];
  id: any;
  imagesFile: any[] = [];
  itemCategoryList: any[] = [];
  public carouselAnimation: CarouselAnimationEffect = 'Fade';

  // Creating a new instance of Item
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
  
  public getThumpImage(index: number): string {
    const images = ['cardinal', 'hunei', 'costa-rica', 'kaohsiung', 'bee-eater'];
    return `./assets/carousel/images/${images[index]}.png`;
  }
  constructor(private route: Router, private _service: ItemRestControllerService, private attachementService: AttachmentRestControllerService, private itemCategoryRestControllerService: ItemCategoryRestControllerService) { }

  ngOnInit() {
    this.id = history.state.id;
    this.getCategoryList();
    if (this.id != null) {
      this.object.id = this.id;
      this.getAttachedList(); 
      this.load();
    } else {
      this.object = this.newItem;
    }
  }

  getCategoryList() {
    this.itemCategoryRestControllerService.getAllItemCategory().subscribe((res: any) => {
      if (res != null) {
        this.itemCategoryList = res;
      } else {
        alert("Something went wrong!")
      }
    });
  }


  selectCategory(selectedItem: any) {
    this.object.itemCategory = selectedItem;
  }





  save(object: any) {
    this._service.saveItem(this.object.itemCategory.id, object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/ItemList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load() {
    this._service.loadItem(this.id).subscribe((res: any) => {
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/ItemList'])
  }



  Attacher() {
    const navigationExtras: NavigationExtras = {
      state: {
        parentId: this.object.id
      }
    };
    this.route.navigate(['/Adm/AttachementList'], navigationExtras)
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
