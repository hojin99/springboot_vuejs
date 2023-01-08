module.exports = {
    configureWebpack: {
        performance: {
            hints: false
        },
    },
    chainWebpack: (config) => {
        const svgRule = config.module.rule('svg');
        svgRule.uses.clear();
        svgRule
          .use('babel-loader')
          .loader('babel-loader')
          .end()
          .use('vue-svg-loader')
          .loader('vue-svg-loader');
      },
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