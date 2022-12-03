import Vue from 'vue';
import VueI18n from "vue-i18n"
import en from '@/assets/i18n/en.json';
import ko from '@/assets/i18n/ko.json';

const messages = {
    en,
    ko
}

Vue.use(VueI18n);
 
const i18n = new VueI18n({
    locale: navigator.language.substring(0, 2),
    fallbacklocale: 'en',
    silentFallbackWarn: true,
    messages   
});

export default i18n;
