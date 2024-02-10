import { Component, OnInit } from '@angular/core';
import { CountryRestControllerService } from './../../../../../libs/openapi/src/api/countryRestController.service';
import { Country } from 'libs/openapi/src/model/country';
import { Router } from '@angular/router';

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css']
})
export class CountryListComponent implements OnInit{

   constructor(private  _countryService: CountryRestControllerService) { }
  ngOnInit(): void {
    this.load();
    }

  countryList: Country[] = [];


  load() {
    this._countryService.getAll2().subscribe((data) =>
      this.countryList = data
    )
  }

}
