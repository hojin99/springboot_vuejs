/** @module */

import { debounce } from 'lodash-es';

/**
 * @param {Element} element
 * @returns {number}
 */
function getClientWidth(element) {
    return element && element.clientWidth ? element.clientWidth : 0;
}

/**
 * @param {Element} element
 * @returns {number}
 */
function getClientHeight(element) {
    return element && element.clientHeight ? element.clientHeight : 0;
}

/**
 * @param {Element} element
 * @param {function(): undefined} callback
 * @param {number} debounceDelay
 * @returns {function(): undefined} - observe를 stop 하는 function.
 */
function observePolyfill(element, callback, debounceDelay) {
    let prevWidth = getClientWidth(element);
    let prevHeight = getClientHeight(element);
    let timeoutId;

    function check() {
        const width = getClientWidth(element);
        const height = getClientHeight(element);
        if ((width !== prevWidth) || (height !== prevHeight)) {
            prevWidth = width;
            prevHeight = height;
            callback();
        }
        timeoutId = setTimeout(check, debounceDelay);
    }
    timeoutId = setTimeout(check, debounceDelay);

    return function () {
        if (timeoutId !== undefined) {
            clearTimeout(timeoutId);
            timeoutId = undefined;
        }
    };
}

/**
 * @param {Element} element
 * @param {function(): undefined} callback
 * @param {number} [debounceDelay]
 * @returns {function(): undefined} - observe를 stop 하는 function.
 */
export function observe(element, callback, debounceDelay) {
    if (! debounceDelay)
        debounceDelay = 50;
    if (window.ResizeObserver) {
        const debouncedCallback = debounce(callback, debounceDelay);
        const observer = new window.ResizeObserver(debouncedCallback);
        observer.observe(element);
        return function () { observer.disconnect(); };
    }
    else
        return observePolyfill(element, callback, debounceDelay);
}
