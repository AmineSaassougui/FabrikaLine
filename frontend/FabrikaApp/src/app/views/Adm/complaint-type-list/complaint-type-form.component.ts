import { Component, OnInit, ViewEncapsulation  } from '@angular/core';
import { NavigationExtras, Router } from '@angular/router';
import {
  ComplaintCategoryRestControllerService, ComplaintType,
  ComplaintTypeControllerService
} from 'libs/openapi/src';
import { CarouselAnimationEffect } from '@syncfusion/ej2-angular-navigations';

@Component({
  selector: 'app-complaint-type-form',
  templateUrl: './complaint-type-form.component.html',
  styleUrl: './complaint-type-form.component.css',
  encapsulation: ViewEncapsulation.None

})
export class ComplaintTypeFormComponent implements OnInit {
  object: any = {}; // Initialize object with empty object
  ok = true;
  categoryId: number = 0;
  categoryName: any = "Catégorie article";
  slides: any[] = [];
  id: any;
  imagesFile: any[] = [];
  complaintCategoryList: any[] = [];
  public carouselAnimation: CarouselAnimationEffect = 'Fade';

  // Creating a new instance of ComplaintType
  newComplaintType: ComplaintType = {
    code: undefined,
    description: undefined,
    complaintCategory: {
      id: undefined,
      code: undefined,
      description: undefined
    }
  };

 /* public getThumpImage(index: number): string {
    const images = ['cardinal', 'hunei', 'costa-rica', 'kaohsiung', 'bee-eater'];
    return `./assets/carousel/images/${images[index]}.png`;
  }

  */

  constructor(private route: Router, private _service: ComplaintTypeControllerService,  private complaintCategoryService: ComplaintCategoryRestControllerService) { }

  ngOnInit() {
    this.id = history.state.id;
    this.getCategoryList();
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    } else {
      this.object = this.newComplaintType;
    }
  }

  getCategoryList() {
    this.complaintCategoryService.getAllComplaintCategory().subscribe((res: any) => {
      if (res != null) {
        this.complaintCategoryList = res;
      } else {
        alert("Something went wrong!")
      }
    });
  }


  selectCategory(selectedComplaintType: any) {
    this.object.complaintCategory = selectedComplaintType;
  }





  save(object: any) {
    this._service.saveComplaintType(this.object.complaintCategory.id, object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/ComplaintTypeList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load() {
    this._service.loadComplaintType(this.id).subscribe((res: any) => {
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/ComplaintTypeList'])
  }
}
