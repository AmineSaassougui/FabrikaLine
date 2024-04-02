import { NgModule } from '@angular/core';
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
        ToastModule, CarouselComponent, CarouselIndicatorsComponent, CarouselInnerComponent, CarouselItemComponent, CarouselCaptionComponent, CarouselControlComponent,
    ],
    declarations: [HomeComponent,ItemViewComponent],
    exports:[ItemViewComponent],

})
export class HomeModule { }
