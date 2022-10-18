<script setup>
import { ref } from "vue";
import { invoke } from "@tauri-apps/api/tauri";
import axios from "axios";

const greetMsg = ref("");
const name = ref("");

async function greet() {
  axios.get("http://localhost:9012/beat").then(res=>{
    console.log(res);
    greetMsg.value = res.data;
  })
}

</script>

<template>
  <div class="card">
    <input id="greet-input" v-model="name" placeholder="Enter a name..." />
    <button type="button" @click="greet()">Greet</button>
  </div>

  <p>{{ greetMsg }}</p>
</template>
