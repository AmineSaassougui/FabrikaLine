import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, NavigationExtras } from '@angular/router';
import { User } from './../../../../../libs/openapi/src/model/user';
import {
  City,
  CityRestControllerService,
  CountryRestControllerService,
  UserGenderRestControllerService,
  UserRestControllerService,
  UserStatusRestControllerService,
  UserTypeRestControllerService
} from 'libs/openapi/src';
import { CarouselAnimationEffect } from '@syncfusion/ej2-angular-navigations';


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
})
export class UserFormComponent implements OnInit {
   object: any = {}; // Initialize object with empty object
  ok = true;
  userTypeId: number = 0;
  userGenderId: number = 0;
  userStatusId: number = 0;
  cityId: number = 0;
  countryId: number = 1;

  userTypeName: any = "Typeutilisateur ";
  userGenderName: any = "Genre utilisateur";
  userStatusName: any = "Status utilisateur";
  cityName: any = "Cité utilisateur";
  countryName: any = "Pays utilisateur";

  slides: any[] = [];
  id: any;
  userTypeList: any[] = [];
  userGenderList: any[] = [];
  userStatusList: any[] = [];
  cityList: any[] = [];
  countryList: any[] = [];

  public carouselAnimation: CarouselAnimationEffect = 'Fade';

  // Creating a new instance of Item
  newUser: User = {
    name: undefined,
    age: undefined,
    description: undefined,
    zipcode:undefined,
    note:undefined,
    contactNumber:undefined,
    email:undefined,
    password:undefined,

    userType: {
      id: undefined,
      code: undefined,
      description: undefined
    },
    userGender: {
      id: undefined,
      code: undefined,
      description: undefined
    },
    userStatus: {
      id: undefined,
      code: undefined,
      description: undefined
    },
    city: {
      id: undefined,
      code: undefined,
      description: undefined
    },
    country: {
      id: undefined,
      code: undefined,
      description: undefined
    }


  };


  constructor(private route: Router, private _service: UserRestControllerService , private userTypeRestControllerService: UserTypeRestControllerService, private userGenderRestControllerService: UserGenderRestControllerService,  private userStatusRestControllerService: UserStatusRestControllerService, private cityRestControllerService: CityRestControllerService, private countryRestControllerService: CountryRestControllerService) { }

  ngOnInit() {
    this.id = history.state.id;
    this.getTypeUserList();
    this.getGenderList();
    this.getStatusList();
    // this.getCityList();
    this.getCountryList();
    if (this.id != null) {
      this.object.id = this.id;
      this.load();
    } else {
      this.object = this.newUser;
    }
  }

  getTypeUserList() {
    this.userTypeRestControllerService.getAllUserType().subscribe((res: any) => {
      if (res != null) {
        this.userTypeList = res;
      } else {
        alert("Something went wrong!")
      }
    });
  }
  getGenderList() {
    this.userGenderRestControllerService.getAllUserGender().subscribe((res: any) => {
      if (res != null) {
        this.userGenderList = res;
      } else {
        alert("Something went wrong!")
      }
    });
  }
  getStatusList() {
    this.userStatusRestControllerService.getAllUserStatus().subscribe((res: any) => {
      if (res != null) {
        this.userStatusList = res;
      } else {
        alert("Something went wrong!")
      }
    });
  }
  getCountryList() {
    this.countryRestControllerService.getAllCountry().subscribe((res: any) => {
      if (res != null) {
        this.countryList = res;
      } else {
        alert("Something went wrong!")
      }
    });
  }

  // getCityList() {
  //   this.cityRestControllerService.getCitiesByCountry(this.countryId).subscribe((res: City[]) => {
  //     console.log('Response from getCitiesByCountry:', res);
  //     this.cityList = res;
  //   }, (error) => {
  //     console.error('Error fetching cities:', error);
  //     alert("Something went wrong!");
  //   });
  // }





  selectType(selectedType: any) {
    this.object.userType = selectedType;
  }
  selectGender(selectedGender: any) {
    this.object.userGender = selectedGender;
  }
  selectStatus(selectedStatus: any) {
    this.object.userStatus = selectedStatus;
  }
  selectCity(selectedCity: City) {
    this.object.city = selectedCity;
  }
  selectCountry(selectedCountry: any) {
    this.object.country = selectedCountry;
  }





  save(object: any) {
    this._service.saveUser(this.object.userType.id,this.object.userGender.id,this.object.userStatus.id,this.object.country.id, object).subscribe((res: any) => {
      if (res != null) {
        this.route.navigate(['/Adm/UserList'])
      } else {
        alert("Something went wrong!")
      }
    });
  }

  load() {
    this._service.loadUser(this.id).subscribe((res: any) => {
      this.object = res;
    });
  }

  cancel() {
    this.route.navigate(['/Adm/UserList'])
  }

}
















