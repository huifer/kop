<template>
  <div>hello world</div>
  <a-date-picker></a-date-picker>
  <div>
    <button @click="fff">hhh</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  methods: {
    fff() {
      let d = "2022-01-01";
      let t = "00:00:00";
      let cs = `${d} 00:00:00`;
      console.log("111");
      let ddd = `http://127.0.0.1:9012/table/group/page?date[]=2022-10-18&date[]=2022-10-21&updateStartTime=${cs}&updateEndTime=${cs}&page=0&size=10`;
      console.log(ddd);
      // 1. 小丹 空格转换为了+
      // + 不是浏览器干的
      // 2. 带了data[]能不能请求
      // axios.get(`http://127.0.0.1:9012/table/group/page?updateStartTime=2022-01-01 00:00:01&updateEndTime=${cs}&page=0&size=10`).then(res => {
      //   console.log(res);
      // });

      axios.get(`http://127.0.0.1:9012/table/group/page?date[]=2022-10-18&date[]=2022-10-21&updateStartTime=2022-01-01 00:00:01&updateEndTime=${cs}&page=0&size=10`).then(res => {
        console.log(res);
      });

      console.log(cs);
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
