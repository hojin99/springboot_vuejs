import Vue from 'vue';
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { faUserSecret } from "@fortawesome/free-solid-svg-icons";
import { faTwitter } from "@fortawesome/free-brands-svg-icons";
import { faHospital } from "@fortawesome/free-regular-svg-icons";

library.add(faUserSecret, faTwitter, faHospital );

Vue.component('font-awesome-icon', FontAwesomeIcon);