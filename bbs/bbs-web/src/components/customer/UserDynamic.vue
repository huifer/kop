<!--用户动态-->
<template>
  <div>
    <UserDynamicListSinglet></UserDynamicListSinglet>
  </div>
</template>

<script>
import UserDynamicListSinglet from "@/components/customer/UserDynamicListSinglet";

export default {
  name: "UserDynamic",
  components: {UserDynamicListSinglet},
  data() {
    return {
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
    }
  }
}
</script>

<style scoped>
.c :after {
  content: "";
  position: absolute;
  top: 50%;
  right: 0;
  margin-top: -1rem;
  width: 1px;
  height: 2rem;
  background-color: #ebebeb;


}

.c:before {
  content: "";
  position: absolute;
  top: 50%;
  right: 0;
  margin-top: -1rem;
  width: 1px;
  height: 2rem;
  background-color: #ebebeb;


}

</style>