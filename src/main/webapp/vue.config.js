module.exports = {
    configureWebpack: {
        performance: {
            hints: false
        },
    },
    // chainWebpack: config => {
    // },
    css: {
        loaderOptions: {
            sass: {
                additionalData: `
                    @import '@/scss/common.scss';
                `
              },
        }
    },
    devServer: {
        port: 19002,
        proxy: {
            '^/': {
                target: 'http://localhost:19001',
                changeOrigin: true
            }
        },
    },
}