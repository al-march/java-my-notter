import { Injectable } from '@angular/core';
import { ApiRoute, BaseApiService } from '@app/core/services';
import { NoteCreateDto, NoteDto } from '@app/core/dto';

@ApiRoute('api/v1/note')
@Injectable({
  providedIn: 'root'
})
export class NoteService extends BaseApiService {
  create(dto: NoteCreateDto) {
    return this.http.post(`${this.url}`, dto);
  }

  update(dto: NoteDto) {
    return this.http.put<NoteDto>(`${this.url}/${dto.id}`, dto);
  }

  get(id: number | string) {
    return this.http.get<NoteDto>(`${this.url}/${id}`);
  }

  getAll() {
    return this.http.get<NoteDto[]>(`${this.url}`);
  }
}
