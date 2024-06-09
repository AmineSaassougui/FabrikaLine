import { ItemFormComponent } from './item/item-form.component';
import { ItemListComponent } from './item/item-list.component';
import { ItemCategoryFormComponent } from './item-category/item-category-form.component';
import { ItemCategoryListComponent } from './item-category/item-category-list.component';
import { AttachementListComponent } from './attachement/attachement-list.component';
import { AttachementFormComponent } from './attachement/attachement-form.component';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CardModule, CarouselModule, GridModule, ToastModule } from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
import { AdministrationComponent } from './administration.component';
import { AdministrationRoutingModule } from './administration-routing.module';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-list/user-form.component';

import { CountryListComponent } from './country-list/country-list.component';
import { UserGenderListComponent } from './user-gender/user-gender-list.component';
import { UserGenderFormComponent } from './user-gender/user-gender-form.component';
import { CarouselAllModule, CarouselAnimationEffect, CarouselComponent,  CarouselModule as CarouselModuleSync } from '@syncfusion/ej2-angular-navigations';
import { DropDownListAllModule } from '@syncfusion/ej2-angular-dropdowns';
import { ButtonAllModule, SwitchAllModule } from '@syncfusion/ej2-angular-buttons';
import { ComplaintTypeListComponent } from './complaint-type-list/complaint-type-list.component';
import {OrderStatusListComponent} from "./order-status/order-status-list.component";
import {OrderStatusFormComponent} from "./order-status/order-status-form.component";

import {
  ColumnChooserService,
  EditService,
  ExcelExportService,
  FreezeService,
  GridModule as syncGridModule,
  PageService,
  PagerModule,
  PdfExportService,
  ReorderService,
  SortService,
  ToolbarService,
  ResizeService as GridResizeService,
} from '@syncfusion/ej2-angular-grids';
import {
  AvatarModule,
  BadgeModule,
  BreadcrumbModule,
  ButtonGroupModule,
  ButtonModule,
  DropdownModule,
  FooterModule,
  FormModule,
  HeaderModule,
  ListGroupModule,
  NavModule,
  ProgressModule,
  SharedModule,
  SidebarModule,
  TabsModule,
  UtilitiesModule,

} from '@coreui/angular';
import {ComplaintTypeFormComponent} from "./complaint-type-list/complaint-type-form.component";
@NgModule({
  imports: [
    CardModule,
    GridModule,
    IconModule,
    CommonModule,
    AdministrationRoutingModule,
    syncGridModule,
    FormsModule, AvatarModule,
    BadgeModule,
    BreadcrumbModule,
    ButtonGroupModule,
    ButtonModule,
    DropdownModule,
    FooterModule,
    FormModule,
    HeaderModule,
    ListGroupModule,
    NavModule,
    ProgressModule,
    SharedModule,
    SidebarModule,
    TabsModule,
    UtilitiesModule,
    ToastModule,
    CarouselModule,
    CarouselModuleSync,
    CarouselAllModule,
    DropDownListAllModule,
    ButtonAllModule, SwitchAllModule
  ],
  declarations: [ComplaintTypeListComponent,ComplaintTypeFormComponent,OrderStatusListComponent,OrderStatusFormComponent,UserFormComponent, AttachementListComponent, AttachementFormComponent, AdministrationComponent, UserListComponent, CountryListComponent, UserGenderListComponent, UserGenderFormComponent, ItemFormComponent, ItemListComponent, ItemCategoryListComponent, ItemCategoryFormComponent
  ],
  schemas:[CUSTOM_ELEMENTS_SCHEMA],

  exports: [ComplaintTypeListComponent,ComplaintTypeFormComponent,OrderStatusListComponent,OrderStatusFormComponent, UserListComponent,UserFormComponent, CountryListComponent, UserGenderListComponent, UserGenderFormComponent, ItemFormComponent, ItemListComponent, ItemCategoryListComponent, ItemCategoryFormComponent]
})
export class AdministrationModule {
}
