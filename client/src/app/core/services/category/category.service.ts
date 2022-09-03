import { Injectable } from '@angular/core';
import { ApiRoute, BaseApiService } from '@app/core/services';
import { CategoryCreateDto, CategoryDto } from '@app/core/dto';

@ApiRoute('category')
@Injectable({
  providedIn: 'root'
})
export class CategoryService extends BaseApiService {

  create(dto: CategoryCreateDto) {
    return this.http.post<CategoryDto>(`${this.url}`, dto);
  }

  update(dto: CategoryDto) {
    return this.http.put<CategoryDto>(`${this.url}/${dto.id}`, dto);
  }

  getAll() {
    return this.http.get<CategoryDto[]>(`${this.url}`);
  }

  get(id: number) {
    return this.http.get<CategoryDto>(`${this.url}/${id}`);
  }
}
