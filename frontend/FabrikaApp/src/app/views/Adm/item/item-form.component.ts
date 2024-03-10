import { Component, OnInit } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import { AttachmentCategoryRestControllerService, AttachmentRestControllerService, ItemRestControllerService, ItemCategoryRestControllerService } from 'libs/openapi/src';
import { Item } from './../../../../../libs/openapi/src/model/item';

@Component({
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  styleUrls: ['./item-form.component.css']
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

  constructor(private route: Router, private _service: ItemRestControllerService, private attachementService: AttachmentRestControllerService, private itemCategoryRestControllerService: ItemCategoryRestControllerService) { }

  ngOnInit() {
    this.id = history.state.id;
    this.getCategoryList();
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
      this.loadAttachedList();
    } else {
      this.object = this.newItem;
    }
  }

  getCategoryList() {
    this.itemCategoryRestControllerService.getAll4().subscribe((res: any) => {
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


  async loadAttachedList() { // Define the method as asynchronous
    await this.getAttachedList(); // Await the completion of getAttachedList()
    // Code here will run after getAttachedList() completes
  }


  save(object: any) {
    this._service.save(this.object.itemCategory.id, object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/ItemList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load() {
    this._service.load5(this.id).subscribe((res: any) => {
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
    this.attachementService.getAttachmentByParentId(this.object.id).subscribe((res: any) => {
      if (res != null) {
        this.imagesFile = res;
        this.slides.push({
          src: './../../../../assets/images/angular.jpg',
          title: 'First slide',
          subtitle: 'Nulla vitae elit libero, a pharetra augue mollis interdum.'
        }, {
          src: './../../../../assets/images/angular.jpg',
          title: 'Second slide',
          subtitle: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'
        }, {
          src: './../../../../assets/images/angular.jpg',
          title: 'Third slide',
          subtitle: 'Praesent commodo cursus magna, vel scelerisque nisl consectetur.'
        });
      } else {
        alert("Something went wrong!")
      }
    });
  }
}
