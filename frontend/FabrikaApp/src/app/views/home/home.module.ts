import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {
    CardModule, CarouselCaptionComponent,
    CarouselComponent, CarouselControlComponent,
    CarouselIndicatorsComponent,
    CarouselInnerComponent, CarouselItemComponent,
    GridModule,
    ToastModule
} from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
import {ItemViewComponent} from "./item-view/item-view.component";
import {HomeComponent} from "./home.component";

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
import {HomeRoutingModule} from "./home-routing.module";
import { NgParticlesModule } from 'ng-particles';
import {ItemDetailsComponent} from "./item-details/item-details.component";
import {CarouselModule} from "@syncfusion/ej2-angular-navigations";

@NgModule({
  imports: [
    CardModule, HomeRoutingModule,
    GridModule,
    IconModule,
    CommonModule,
    syncGridModule, FormsModule, AvatarModule,
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
    NgParticlesModule,
    ToastModule, CarouselComponent, CarouselIndicatorsComponent, CarouselInnerComponent, CarouselItemComponent, CarouselCaptionComponent, CarouselControlComponent, CarouselModule,
  ],
    declarations: [HomeComponent,ItemViewComponent,ItemDetailsComponent],
    schemas:[CUSTOM_ELEMENTS_SCHEMA],
    exports:[ItemViewComponent,ItemDetailsComponent],

})
export class HomeModule { }
