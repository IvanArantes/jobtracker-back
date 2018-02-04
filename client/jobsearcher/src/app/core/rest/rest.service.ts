import { Injectable } from '@angular/core';
import {environment} from '../environment/environment.local';

@Injectable()
export class RestService {

  private url: string;
  private urlSimple: string;

  constructor() {
    this.url = environment.url;
    this.urlSimple = environment.urlSimple;
  }

  getUrl(): string {
    return this.url;
  }

  getUrlSimple(): string {
    return this.urlSimple;
  }
}
