import axios from "axios";

export function pageCategory(page, size, param) {
  return axios.get(
      "http://localhost:9018/manager/goods/category/page/" + page + "/"
      + size, {
        params: param,

      });
}

export function craeteCategory(param) {
  return axios.post("http://localhost:9018/manager/goods/category/create",
      param)
}

export function ListCategory(){
  return axios.get("http://localhost:9018/manager/goods/category/list",)
}