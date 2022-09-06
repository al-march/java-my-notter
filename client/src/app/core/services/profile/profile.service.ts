import { Injectable } from '@angular/core';
import { ApiRoute, BaseApiService } from '@app/core/services';
import { UserDto } from '@app/core/dto';

@ApiRoute('/api/v1/profile')
@Injectable({
  providedIn: 'root'
})
export class ProfileService extends BaseApiService {
  get() {
    return this.http.get<UserDto>(`${this.url}`);
  }
}
