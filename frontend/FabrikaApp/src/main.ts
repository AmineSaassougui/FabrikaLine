/// <reference types="@angular/localize" />

import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';

import { registerLicense } from '@syncfusion/ej2-base';

// Registering Syncfusion license key
registerLicense("Ngo9BigBOggjHTQxAR8/V1NAaF1cXmhKYVJ3WmFZfVpgd19GaFZTTGY/P1ZhSXxXdkdiWX5bcHxXT2VYUk0=");

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
