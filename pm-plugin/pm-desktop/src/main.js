import {createApp} from "vue";
import "./style.css";
import App from "./App.vue";
import UngeUI from 'ungeui';
import 'ungeui/dist/style.css';

const app = createApp(App);
app.use(UngeUI);

app.mount("#app");
