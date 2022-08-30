import { Injectable } from '@angular/core';
import { ApiRoute, BaseApiService } from '@app/core/services';
import { TagCreateDto, TagDto } from '@app/core/dto';

@ApiRoute('tag')
@Injectable({
  providedIn: 'root'
})
export class TagService extends BaseApiService {

  create(dto: TagCreateDto) {
    return this.http.post<TagDto>(`${this.url}`, dto);
  }

  update(id: number, dto: TagCreateDto) {
    return this.http.put<TagDto>(`${this.url}/${id}`, dto);
  }

  getAll() {
    return this.http.get<TagDto[]>(`${this.url}/all`);
  }
}
