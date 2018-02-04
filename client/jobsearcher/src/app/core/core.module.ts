import {NgModule} from '@angular/core';

import {AuthService} from './auth/auth.service';
import {RestService} from './rest/rest.service';

@NgModule({
  imports: [],
  providers: [
    AuthService,
    RestService
  ],
})
export class CoreModule {}
